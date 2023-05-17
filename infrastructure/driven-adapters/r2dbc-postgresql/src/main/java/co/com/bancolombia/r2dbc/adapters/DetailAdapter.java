package co.com.bancolombia.r2dbc.adapters;

import co.com.bancolombia.model.DetailsBuy;
import co.com.bancolombia.r2dbc.mapper.Mapper;
import co.com.bancolombia.r2dbc.repositories.detail.DetailRepository;
import co.com.bancolombia.r2dbc.repositories.detail.entities.DetailEntity;
import co.com.bancolombia.usecase.details.gateway.DetailGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DetailAdapter implements DetailGateway {
    private final DetailRepository detailRepository;
    @Override
    public Mono<DetailsBuy> createdDetail(DetailsBuy detailsBuy) {
        return detailRepository.save(Mapper.map(detailsBuy, DetailEntity.class))
                .map(detailEntity -> Mapper.map(detailEntity, DetailsBuy.class));
    }
}
