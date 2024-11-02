package lotto.controller;

import lotto.domain.LottoPurchaseAmount;
import lotto.view.InputView;

import static lotto.view.InputView.readInput;


public class LottoController {

    public void run() {
        InputView.printPurchaseAmountPrompt();
        int purchaseAmount = LottoPurchaseAmount.from(readInput()).getPurchaseAmount();
    }

}