package lotto.controller;

import lotto.view.InputView;

public class Controller {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int lottoPurchaseAmount = inputView.readLottoPurchaseAmount();

    }
}
