package lotto.Controller;

import lotto.Utils.UserInput;

public class LottoGameController {
    private final UserInput userInput;

    public LottoGameController() {
        userInput = new UserInput();
    }

    public void run() {
        ready();
    }

    private void ready() {
        String purchaseAmountInput = userInput.purchaseAmount();
    }

}