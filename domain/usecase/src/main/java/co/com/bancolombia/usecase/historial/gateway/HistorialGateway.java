package co.com.bancolombia.usecase.historial.gateway;

import co.com.bancolombia.model.dto.HistorialDTO;
import reactor.core.publisher.Mono;

public interface HistorialGateway {
    Mono<HistorialDTO> generarHistorial(Integer idBuy);
}
