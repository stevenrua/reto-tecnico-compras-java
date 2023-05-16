package co.com.bancolombia.api.controllers;

import co.com.bancolombia.model.Buys;
import co.com.bancolombia.usecase.buys.BuysUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/buy")
@RequiredArgsConstructor
public class BuyController {
    private final BuysUseCase buysUseCase;
    @PostMapping
    public Mono<Buys> createdBuy(@RequestBody Buys buy) {
        return buysUseCase.createdBuy(buy);

    }
}
