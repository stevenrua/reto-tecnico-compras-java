package co.com.bancolombia.api.controllers;

import co.com.bancolombia.model.Client;
import co.com.bancolombia.model.DetailsBuy;
import co.com.bancolombia.model.dto.CompraRequest;
import co.com.bancolombia.usecase.details.DetailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/detail")
@RequiredArgsConstructor
public class DetailController {
    private final DetailUseCase detailUseCase;
    @PostMapping
    public Mono<DetailsBuy> createdClient(@RequestBody DetailsBuy detailsBuy) {
        return detailUseCase.createdDetail(detailsBuy);

    }
}
