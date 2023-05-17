package co.com.bancolombia.usecase.buys.gateway;

import co.com.bancolombia.model.Client;
import co.com.bancolombia.model.dto.CompraRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientGateway {
    Mono<Void> createdClient(CompraRequest compraRequest);
}