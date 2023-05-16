package co.com.bancolombia.usecase.buys.gateway;

import co.com.bancolombia.model.Buys;
import co.com.bancolombia.model.Products;
import reactor.core.publisher.Mono;

public interface BuyGateway {
    Mono<Buys> createdBuy(Buys buy);
}
