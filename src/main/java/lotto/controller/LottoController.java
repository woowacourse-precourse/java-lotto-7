package lotto.controller;

import lotto.domain.Lottery;
import lotto.domain.PurchasePrice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private Lottery prepareLottery() {
        OutputView.printPurchaseInputText();
        PurchasePrice purchasePrice = InputView.inputPurchasePrice();
        return new Lottery();
    }
}
