package lotto.controller;

import lotto.service.LottoMachine;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final LottoMachine lottoMachine;

    public LottoController(final InputView inputView, final LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        Long money = inputView.inputMoney();
        lottoMachine.buyLotto(money);
    }
}
