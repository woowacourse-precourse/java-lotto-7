package lotto.controller;

import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BuyController {
    private final InputView inputView;
    private final LottoMachine lottoMachine;
    private final OutputView outputView;

    public BuyController(final InputView inputView, final LottoMachine lottoMachine, final OutputView outputView) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
        this.outputView = outputView;
    }

    public void buy() {
        Long money = inputView.inputMoney();
        lottoMachine.buyLotto(money);
        outputView.printPurchaseLotto(lottoMachine.getPurchasedLotto());
    }
}
