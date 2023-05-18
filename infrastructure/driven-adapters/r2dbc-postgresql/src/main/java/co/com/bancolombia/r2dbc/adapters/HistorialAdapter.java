package co.com.bancolombia.r2dbc.adapters;

import co.com.bancolombia.model.Client;
import co.com.bancolombia.model.Products;
import co.com.bancolombia.model.dto.HistorialDTO;
import co.com.bancolombia.model.dto.ProductResponse;
import co.com.bancolombia.usecase.buys.gateway.ClientGateway;
import co.com.bancolombia.usecase.details.gateway.DetailGateway;
import co.com.bancolombia.usecase.historial.gateway.HistorialGateway;
import co.com.bancolombia.usecase.products.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistorialAdapter implements HistorialGateway {
    @Autowired
    private ProductGateway productGateway;
    @Autowired
    private ClientGateway clientGateway;
    @Autowired
    private DetailGateway detailGateway;
    @Override
    public Mono<HistorialDTO> generarHistorial(Integer idBuy) {
        return detailGateway.findDetailById(idBuy)
                .flatMap(detailsBuy -> productGateway.findById(detailsBuy.getProductId())
                        .map(product -> {
                            ProductResponse productResponse = new ProductResponse();
                            productResponse.setNombreProducto(product.getName());
                            productResponse.setQuantiy(detailsBuy.getQuantity());
                            return productResponse;
                        })
                )
                .collectList()
                .flatMap(productList -> clientGateway.findClientById(idBuy)
                        .map(clientDTO -> {
                            HistorialDTO historialDTO = new HistorialDTO();
                            historialDTO.setClient(clientDTO);
                            historialDTO.setProducts(productList);
                            return historialDTO;
                        })
                );
    }
}
