package co.com.bancolombia.r2dbc.repositories.detail;

import co.com.bancolombia.r2dbc.repositories.detail.entities.DetailEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DetailRepository extends ReactiveCrudRepository<DetailEntity, Integer> {
}
