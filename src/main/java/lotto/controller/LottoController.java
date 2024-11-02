package lotto.controller;

import lotto.view.InputReader;

public class LottoController {

    public void startLotto() {
        InputReader inputReader = new InputReader();
        String PurchaseAmount = inputReader.inputPurchaseAmount();
    }
}
