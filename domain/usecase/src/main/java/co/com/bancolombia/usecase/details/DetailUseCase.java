package co.com.bancolombia.usecase.details;

import co.com.bancolombia.model.DetailsBuy;
import co.com.bancolombia.usecase.details.gateway.DetailGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DetailUseCase {
    private final DetailGateway detailGateway;
    public Mono<DetailsBuy> createdDetail(DetailsBuy detailBuy){

        return detailGateway.createdDetail(detailBuy);
    }
}
