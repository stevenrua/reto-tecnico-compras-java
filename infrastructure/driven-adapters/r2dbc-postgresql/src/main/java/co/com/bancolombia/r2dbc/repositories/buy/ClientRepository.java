package co.com.bancolombia.r2dbc.repositories.buy;

import co.com.bancolombia.r2dbc.repositories.buy.entities.ClientEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClientRepository extends ReactiveCrudRepository<ClientEntity, Integer> {
}
