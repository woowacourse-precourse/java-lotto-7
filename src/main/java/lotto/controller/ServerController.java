package lotto.controller;

import lotto.model.lotto.Lottos;
import lotto.model.money.Money;
import lotto.service.LottoService;

public class ServerController {

    private final LottoService lottoService;

    public ServerController(final LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        // TODO: IO Operations
        Money mock = Money.from(8000L);

        Lottos lottos = lottoService.offerLottos(mock);

        System.out.println(lottos.toString());
    }
}
