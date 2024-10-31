package lotto.mvc.controller;

import lotto.mvc.view.InputView;

public class LottoController {
    private InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        inputView.showPurchaseAmountMsg();
        String purchaseAmount = inputView.getUserInput();
        purchaseAmount = trimInput(purchaseAmount);
        purchaseAmount = removeDelimiter(purchaseAmount);
    }

    private String trimInput(String input) {
        return input.trim();
    }

    private String removeDelimiter(String input) {
        //정규표현식으로 할 수 있을까
        StringBuilder output = new StringBuilder();

        for (String s : input.split(",", -1)) {
            output.append(s);
        }

        return output.toString();
    }
}
