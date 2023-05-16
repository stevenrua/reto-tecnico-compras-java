package co.com.bancolombia.r2dbc.adapters;

import co.com.bancolombia.model.Buys;
import co.com.bancolombia.r2dbc.mapper.Mapper;
import co.com.bancolombia.r2dbc.repositories.buy.BuyRepository;
import co.com.bancolombia.r2dbc.repositories.buy.entities.BuyEntity;
import co.com.bancolombia.usecase.buys.gateway.BuyGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BuyAdapter implements BuyGateway {
    private final BuyRepository buyRepository;
    @Override
    public Mono<Buys> createdBuy(Buys buy) {

        return buyRepository.save(Mapper.map(buy, BuyEntity.class))
                .map(buyEntity ->  Mapper.map(buyEntity, Buys.class));
    }
}
