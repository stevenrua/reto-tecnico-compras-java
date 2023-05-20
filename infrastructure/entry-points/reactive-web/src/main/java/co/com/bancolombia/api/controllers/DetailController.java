package co.com.bancolombia.api.controllers;

import co.com.bancolombia.model.DetailsBuy;
import co.com.bancolombia.model.dto.HistorialDTO;
import co.com.bancolombia.usecase.details.DetailUseCase;
import co.com.bancolombia.usecase.historial.HistorialUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/detail")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequiredArgsConstructor
public class DetailController {
    private final DetailUseCase detailUseCase;
    private final HistorialUseCase historialUseCase;
    @PostMapping
    public Mono<DetailsBuy> createdDetail(@RequestBody DetailsBuy detailsBuy) {
        return detailUseCase.createdDetail(detailsBuy);
    }

    @GetMapping
    public Flux<DetailsBuy> findAllDetails() {
        return detailUseCase.findAllDetails()
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping("/cosa/{idbuy}")
    public Flux<DetailsBuy> findById(@PathVariable("idbuy") Integer idbuy) {
        return detailUseCase.findDetailById(idbuy)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping("/{idbuy}")
    public Mono<HistorialDTO> Historial(@PathVariable("idbuy") Integer idbuy) {
        return historialUseCase.Historial(idbuy);
    }
}
