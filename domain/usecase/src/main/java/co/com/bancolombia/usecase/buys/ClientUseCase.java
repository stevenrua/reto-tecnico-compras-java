package co.com.bancolombia.usecase.buys;

import co.com.bancolombia.model.Client;
import co.com.bancolombia.model.dto.CompraRequest;
import co.com.bancolombia.usecase.buys.gateway.ClientGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ClientUseCase {
    private final ClientGateway buyGateway;
    public Mono<Client> createdClient(CompraRequest compraRequest){

        return buyGateway.createdClient(compraRequest);
    }
}
