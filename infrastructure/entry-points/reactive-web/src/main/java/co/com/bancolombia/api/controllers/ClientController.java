package co.com.bancolombia.api.controllers;

import co.com.bancolombia.model.Client;
import co.com.bancolombia.model.dto.CompraRequest;
import co.com.bancolombia.usecase.buys.ClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/buy")
@RequiredArgsConstructor
public class ClientController {
    private final ClientUseCase clientUseCase;
    @PostMapping
    public Mono<Void> createdClient(@RequestBody CompraRequest compraRequest) {
        return clientUseCase.createdClient(compraRequest);

    }
}
