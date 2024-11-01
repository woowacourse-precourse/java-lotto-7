package lotto.controller;

import lotto.domain.Lottoes;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.util.SingletonObjectProvider;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = SingletonObjectProvider.getSingletonObject(LottoService.class);
    }

    public Lottoes createLottoes(Money money) {
        return lottoService.createLottoes(money);
    }
}
