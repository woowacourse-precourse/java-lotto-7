package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Money money = getLottoMoney();
    }

    private Money getLottoMoney() {
        outputView.requestLottoMoney();
        int inputLottoMoney = inputView.inputLottoMoney();

        return Money.from(inputLottoMoney);
    }
}
