package co.com.bancolombia.usecase.details.gateway;

import co.com.bancolombia.model.DetailsBuy;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DetailGateway {
    Mono<DetailsBuy> createdDetail(DetailsBuy detailsBuy);
    Flux<DetailsBuy> findDetailById(Integer idbuy);
    Flux<DetailsBuy> findAllDetails();
    
}
