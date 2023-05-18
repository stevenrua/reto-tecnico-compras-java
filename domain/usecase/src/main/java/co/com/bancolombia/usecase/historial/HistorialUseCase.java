package co.com.bancolombia.usecase.historial;

import co.com.bancolombia.model.dto.HistorialDTO;
import co.com.bancolombia.usecase.historial.gateway.HistorialGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class HistorialUseCase {
    private final HistorialGateway historialGateway;
    public Mono<HistorialDTO> Historial(Integer idBuy){
        return historialGateway.generarHistorial(idBuy);
    }
}
