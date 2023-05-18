package co.com.bancolombia.usecase.details.gateway;

import co.com.bancolombia.model.DetailsBuy;
import co.com.bancolombia.model.dto.HistorialDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DetailGateway {
    Mono<DetailsBuy> createdDetail(DetailsBuy detailsBuy);
    Flux<DetailsBuy> findDetailById(Integer idbuy);
    Mono<HistorialDTO> Historial(Integer idBuy);
}
