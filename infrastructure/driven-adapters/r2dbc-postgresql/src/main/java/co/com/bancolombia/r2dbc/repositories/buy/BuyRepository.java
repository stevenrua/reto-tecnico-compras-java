package co.com.bancolombia.r2dbc.repositories.buy;

import co.com.bancolombia.r2dbc.repositories.buy.entities.BuyEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BuyRepository extends ReactiveCrudRepository<BuyEntity, Integer> {
}
