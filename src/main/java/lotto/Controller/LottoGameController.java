package lotto.Controller;

import lotto.Utils.InputRequest;

public class LottoGameController {
    private final InputRequest inputRequest;

    public LottoGameController() {
        inputRequest = new InputRequest();
    }

    public void run() {
        ready();
    }

    private void ready() {
        String purchaseAmountInput = inputRequest.purchaseAmount();
    }
}