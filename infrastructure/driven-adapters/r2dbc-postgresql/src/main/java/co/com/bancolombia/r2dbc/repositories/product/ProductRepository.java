package co.com.bancolombia.r2dbc.repositories.product;

import co.com.bancolombia.model.Products;
import co.com.bancolombia.r2dbc.repositories.product.entities.ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, Integer> {
    public Mono<Products> findByName(String name);
}
