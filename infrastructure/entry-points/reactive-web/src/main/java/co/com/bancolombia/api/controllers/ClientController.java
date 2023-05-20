package co.com.bancolombia.api.controllers;

import co.com.bancolombia.model.Client;
import co.com.bancolombia.model.dto.CompraRequest;
import co.com.bancolombia.r2dbc.helpers.CustomException;
import co.com.bancolombia.usecase.buys.ClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/buy")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequiredArgsConstructor
public class ClientController {
    private final ClientUseCase clientUseCase;
    @PostMapping
    public Mono<Client> createdClient(@RequestBody CompraRequest compraRequest) {
        return clientUseCase.createdClient(compraRequest)
                .onErrorResume(error-> Mono.error(new CustomException(error.getMessage())));

    }

    @ExceptionHandler(CustomException.class)
    public Mono<ResponseEntity<String>> handleCustomException(CustomException ex) {
        HttpStatus status = HttpStatus.CONFLICT;
        String body = "Error: " + ex.getMessage();
        return Mono.just(ResponseEntity.status(status).body(body))
                .onErrorResume(e -> Mono.error(new CustomException(e.getMessage())));
    }
}
