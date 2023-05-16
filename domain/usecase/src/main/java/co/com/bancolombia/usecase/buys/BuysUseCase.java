package co.com.bancolombia.usecase.buys;

import co.com.bancolombia.model.Buys;
import co.com.bancolombia.usecase.buys.gateway.BuyGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BuysUseCase {
    private final BuyGateway buyGateway;
    public Mono<Buys> createdBuy(Buys buy){

        return buyGateway.createdBuy(buy);
    }
}
