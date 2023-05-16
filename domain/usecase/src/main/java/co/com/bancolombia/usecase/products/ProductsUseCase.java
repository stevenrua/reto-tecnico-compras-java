package co.com.bancolombia.usecase.products;

import co.com.bancolombia.model.Products;
import co.com.bancolombia.usecase.products.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductsUseCase {
    private final ProductGateway productGateway;

    public Flux<Products> listProducts(){

        return productGateway.listProducts();
    }

    public Mono<Products> createdProduct(Products product){

        return productGateway.createdProduct(product);
    }
    public Mono<Products> updatedProduct(Products productById, Products productUpdated){

        return productGateway.updatedProduct(productById, productUpdated);
    }

    public Mono<Products> finById(Integer id){

        return productGateway.findById(id);
    }
    public Mono<Products> finByName(String name){

        return productGateway.findByName(name);
    }

    public Mono<Void> deleteProduct(Products product){
        return productGateway.deleteProduct(product);
    }
}
