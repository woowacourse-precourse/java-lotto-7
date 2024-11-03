package lotto.controller;

import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final LottoMachine lottoMachine;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final LottoMachine lottoMachine, OutputView outputView) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
        this.outputView = outputView;
    }

    public void run() {
        Long money = inputView.inputMoney();
        lottoMachine.buyLotto(money);
        outputView.printPurchaseLotto(lottoMachine.getPurchasedLotto());
    }
}
