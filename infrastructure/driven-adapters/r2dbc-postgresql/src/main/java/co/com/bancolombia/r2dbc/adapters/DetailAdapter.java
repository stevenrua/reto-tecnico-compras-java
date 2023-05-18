package co.com.bancolombia.r2dbc.adapters;

import co.com.bancolombia.model.Client;
import co.com.bancolombia.model.DetailsBuy;
import co.com.bancolombia.model.Products;
import co.com.bancolombia.model.dto.HistorialDTO;
import co.com.bancolombia.r2dbc.mapper.Mapper;
import co.com.bancolombia.r2dbc.repositories.detail.DetailRepository;
import co.com.bancolombia.r2dbc.repositories.detail.entities.DetailEntity;
import co.com.bancolombia.usecase.buys.gateway.ClientGateway;
import co.com.bancolombia.usecase.details.gateway.DetailGateway;
import co.com.bancolombia.usecase.products.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DetailAdapter implements DetailGateway {
    private final DetailRepository detailRepository;
    private final ClientGateway clientGateway;
    private final ProductGateway productGateway;
    @Override
    public Mono<DetailsBuy> createdDetail(DetailsBuy detailsBuy) {
        return detailRepository.save(Mapper.map(detailsBuy, DetailEntity.class))
                .map(detailEntity -> Mapper.map(detailEntity, DetailsBuy.class));
    }

    @Override
    public Flux<DetailsBuy> findDetailById(Integer idbuy) {
        return detailRepository.findByBuyId(idbuy);
    }

    @Override
    public Mono<HistorialDTO> Historial(Integer idBuy) {
        //findDetailById(idBuy);
        return findDetailById(idBuy)
                //.flatMapIterable(detailsBuys -> detailsBuys)
                .concatMap(detailsBuy -> productGateway.findById(detailsBuy.getProductId()))
                .collectList()
                .flatMap(productList -> {
                    Mono<Client> clientMono = clientGateway.findClientById(idBuy);

                    return clientMono.map(clientDTO -> {
                        HistorialDTO historialDTO = new HistorialDTO();
                        historialDTO.setClient(clientDTO);
                        historialDTO.setProducts(null);
                        return historialDTO;
                    });
                });
    }
}
