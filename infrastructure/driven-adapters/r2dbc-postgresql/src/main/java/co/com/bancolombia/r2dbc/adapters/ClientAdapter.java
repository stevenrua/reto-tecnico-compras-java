package co.com.bancolombia.r2dbc.adapters;

import co.com.bancolombia.model.Client;
import co.com.bancolombia.model.DetailsBuy;
import co.com.bancolombia.model.Products;
import co.com.bancolombia.model.dto.CompraRequest;
import co.com.bancolombia.model.dto.compraDTO;
import co.com.bancolombia.r2dbc.mapper.Mapper;
import co.com.bancolombia.r2dbc.repositories.buy.ClientRepository;
import co.com.bancolombia.r2dbc.repositories.buy.entities.ClientEntity;
import co.com.bancolombia.r2dbc.repositories.product.ProductRepository;
import co.com.bancolombia.usecase.buys.gateway.ClientGateway;
import co.com.bancolombia.usecase.details.DetailUseCase;
import co.com.bancolombia.usecase.products.ProductsUseCase;
import co.com.bancolombia.usecase.products.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientAdapter implements ClientGateway {
    private final ClientRepository clientRepository;
    private final ProductsUseCase productsUseCase;
    private final DetailUseCase detailUseCase;
    @Override
    public Mono<Client> createdClient(CompraRequest compraRequest) {
        Client client = Client.builder()
                .clientName(compraRequest.getClient().getClientName())
                .identity(compraRequest.getClient().getIdentity())
                .date(compraRequest.getClient().getDate())
                .idType(compraRequest.getClient().getIdType())
                .build();
        Mono<Client> cliente = clientRepository.save(Mapper.map(client, ClientEntity.class))
                .map(clientEntity -> Mapper.map(clientEntity, Client.class));

        Flux.fromIterable(compraRequest.getCompra())
                .flatMap(compraDTO -> productsUseCase.finById(compraDTO.getIdProduct())
                        .flatMap(product -> {
                            Integer inInventory = product.getInInventory() - compraDTO.getQuantity();
                            if(inInventory > product.getMin()){
                                product.setInInventory(inInventory);
                                return productsUseCase.updatedProduct(product, product).flatMap(products -> {
                                    DetailsBuy detailsBuy = DetailsBuy
                                            .builder()
                                            .buyId(1)
                                            .productId(products.getId())
                                            .quantity(compraDTO.getQuantity())
                                            .build();
                                    System.out.println(products.getInInventory());
                                    return detailUseCase.createdDetail(detailsBuy);
                                });
                            }
                            return Mono.empty();
                        })).subscribe();

        return cliente;
    }
}
