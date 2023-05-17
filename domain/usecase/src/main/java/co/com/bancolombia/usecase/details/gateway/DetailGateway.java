package co.com.bancolombia.usecase.details.gateway;

import co.com.bancolombia.model.DetailsBuy;
import reactor.core.publisher.Mono;

public interface DetailGateway {
    Mono<DetailsBuy> createdDetail(DetailsBuy detailsBuy);
}
