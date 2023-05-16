package co.com.bancolombia.r2dbc.adapters;

import co.com.bancolombia.model.Products;
import co.com.bancolombia.r2dbc.mapper.Mapper;
import co.com.bancolombia.r2dbc.repositories.product.ProductRepository;
import co.com.bancolombia.r2dbc.repositories.product.entities.ProductEntity;
import co.com.bancolombia.usecase.products.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductAdapter implements ProductGateway {

    private final ProductRepository productRepository;
    @Override
    public Flux<Products> listProducts() {
        return productRepository.findAll()
                .map(productEntity -> Products.builder()
                        .id(productEntity.getId())
                        .name(productEntity.getName())
                        .inInventory(productEntity.getInInventory())
                        .enabled(productEntity.isEnabled())
                        .min(productEntity.getMin())
                        .max(productEntity.getMax())
                        .build());
    }

    @Override
    public Mono<Products> findById(Integer id) {
        return productRepository.findById(id)
                .map(productEntity -> Mapper.map(productEntity, Products.class));
    }

    @Override
    public Mono<Products> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Mono<Products> createdProduct(Products product) {
        return productRepository.save(ProductEntity.builder()
                        .name(product.getName())
                        .inInventory(product.getInInventory())
                        .enabled(product.isEnabled())
                        .min(product.getMin())
                        .max(product.getMax())
                        .build())
                .map(productEntity -> Products.builder()
                        .id(productEntity.getId())
                        .name(productEntity.getName())
                        .inInventory(productEntity.getInInventory())
                        .enabled(productEntity.isEnabled())
                        .min(productEntity.getMin())
                        .max(productEntity.getMax())
                        .build());
    }

    @Override
    public Mono<Products> updatedProduct(Products productById, Products productUpdated) {
        productById.setName(productUpdated.getName());
        productById.setInInventory(productUpdated.getInInventory());
        productById.setEnabled(productUpdated.isEnabled());
        productById.setMin(productUpdated.getMin());
        productById.setMax(productUpdated.getMax());

        return productRepository.save(Mapper.map(productById, ProductEntity.class))
                .map(productEntity -> Mapper.map(productEntity, Products.class));
    }

    @Override
    public Mono<Void> deleteProduct(Products product) {
        return productRepository.delete(Mapper.map(product, ProductEntity.class));
    }


}
