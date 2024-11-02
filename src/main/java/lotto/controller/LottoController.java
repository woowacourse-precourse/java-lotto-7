package lotto.controller;

import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run(){
        int buyPrice = InputView.buyPrice();
        Money money = new Money(buyPrice);
        lottoService.purchaseLotto(money);

    }


}
