package co.com.bancolombia.r2dbc.repositories.detail;

import co.com.bancolombia.model.DetailsBuy;
import co.com.bancolombia.r2dbc.repositories.detail.entities.DetailEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface DetailRepository extends ReactiveCrudRepository<DetailEntity, Integer> {
    public Flux<DetailsBuy> findByBuyId(Integer buyId);
}
