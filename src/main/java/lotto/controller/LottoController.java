package lotto.controller;

import lotto.model.domain.Pocket;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        String inputMoney = InputView.requestMoney();
        int money = lottoService.moneyValidator(inputMoney);
        Pocket pocket = new Pocket(lottoService.activateLottoMachine(money));
        OutputView.printPurchasedLottoCount(pocket);


    }
}