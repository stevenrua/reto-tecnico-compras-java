package co.com.bancolombia.usecase.details;

import co.com.bancolombia.model.DetailsBuy;
import co.com.bancolombia.model.dto.HistorialDTO;
import co.com.bancolombia.usecase.details.gateway.DetailGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DetailUseCase {
    private final DetailGateway detailGateway;
    public Mono<DetailsBuy> createdDetail(DetailsBuy detailBuy){

        return detailGateway.createdDetail(detailBuy);
    }
    public Flux<DetailsBuy> findDetailById(Integer idBuy){
        return detailGateway.findDetailById(idBuy);
    }

    public Mono<HistorialDTO> Historial(Integer idBuy){
        return detailGateway.Historial(idBuy);
    }
}
