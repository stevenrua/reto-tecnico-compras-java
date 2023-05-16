package co.com.bancolombia.usecase.products.gateway;

import co.com.bancolombia.model.Products;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductGateway {
    Flux<Products> listProducts();
    Mono<Products> createdProduct(Products product);
    Mono<Products> findById(Integer id);
    Mono<Products> findByName(String name);
    Mono<Products> updatedProduct(Products productById, Products productUpdated);
    Mono<Void> deleteProduct(Products product);
}
