package co.com.bancolombia.api.controllers;

import co.com.bancolombia.model.Products;
import co.com.bancolombia.r2dbc.helpers.CustomException;
import co.com.bancolombia.usecase.products.ProductsUseCase;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductsUseCase productsUseCase;


    @GetMapping
    public Flux<Products> listProducts() {

        return productsUseCase.listProducts()
                .onErrorResume(error-> Mono.error(new CustomException(error.getMessage())))
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
    @GetMapping("/{id}")
    public Mono<Products> findById(@PathVariable("id") Integer id) {

        return productsUseCase.finById(id)
                .onErrorResume(error-> Mono.error(new CustomException(error.getMessage())))
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping("/pornombre/{name}")
    public Mono<Products> findByName(@PathVariable("name") String name) {

        return productsUseCase.finByName(name);

    }
    @PostMapping
    public Mono<Products> createdProduct(@RequestBody Products updatedProduct) {
        return productsUseCase.createdProduct(updatedProduct)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST)))
                .onErrorResume(err -> {
                    System.out.println("Error: " + err.getCause().getMessage());
                    return Mono.error(new CustomException(err.getMessage()));
                });
        /*return productsUseCase.finByName(updatedProduct.getName())
                .onErrorResume(error-> Mono.error(new CustomException(error.getMessage())))
                .flatMap(productFindById -> {
                    Integer enInventario = productFindById.getInInventory() + updatedProduct.getInInventory();
                    updatedProduct.setInInventory(enInventario);
                    return productsUseCase.updatedProduct(productFindById, updatedProduct);
                })
                .switchIfEmpty(Mono.defer(()-> productsUseCase.createdProduct(updatedProduct)));*/
    }

    @PutMapping("/{id}")
    public Mono<Products> updatedProduct(@PathVariable("id") Integer id, @RequestBody Products product) {
        return productsUseCase.finById(id)
                .onErrorResume(error-> Mono.error(new CustomException(error.getMessage())))
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .flatMap(products -> {
                    return productsUseCase.updatedProduct(products, product);
                });

    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletedProduct(@PathVariable("id") Integer id) {
        return productsUseCase.finById(id)
                .onErrorResume(error-> Mono.error(new CustomException(error.getMessage())))
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .flatMap(products -> {
                    return productsUseCase.deleteProduct(products);
                });
    }
    @ExceptionHandler(CustomException.class)
    public Mono<ResponseEntity<String>> handleCustomException(CustomException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String body = "Error: " + ex.getMessage();
        return Mono.just(ResponseEntity.status(status).body(body))
                .onErrorResume(e -> Mono.error(new CustomException(e.getMessage())));
    }
}
