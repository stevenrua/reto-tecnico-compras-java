package co.com.bancolombia.api.controllers;

import co.com.bancolombia.model.DetailsBuy;
import co.com.bancolombia.model.dto.HistorialDTO;
import co.com.bancolombia.usecase.details.DetailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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

    @GetMapping("/{idbuy}")
    public Mono<HistorialDTO> Historial(@PathVariable("idbuy") Integer idbuy) {
        return detailUseCase.Historial(idbuy);
    }
}
