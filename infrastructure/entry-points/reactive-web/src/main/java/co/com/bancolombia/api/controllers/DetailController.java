package co.com.bancolombia.api.controllers;

import co.com.bancolombia.model.DetailsBuy;
import co.com.bancolombia.model.dto.HistorialDTO;
import co.com.bancolombia.usecase.details.DetailUseCase;
import co.com.bancolombia.usecase.historial.HistorialUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/detail")
@RequiredArgsConstructor
public class DetailController {
    private final DetailUseCase detailUseCase;
    private final HistorialUseCase historialUseCase;
    @PostMapping
    public Mono<DetailsBuy> createdClient(@RequestBody DetailsBuy detailsBuy) {
        return detailUseCase.createdDetail(detailsBuy);
    }

    @GetMapping("/cosa/{idbuy}")
    public Flux<DetailsBuy> findById(@PathVariable("idbuy") Integer idbuy) {
        return detailUseCase.findDetailById(idbuy);
    }

    @GetMapping("/{idbuy}")
    public Mono<HistorialDTO> Historial(@PathVariable("idbuy") Integer idbuy) {
        return historialUseCase.Historial(idbuy);
    }
}
