package lotto.Controller;

import lotto.Utils.InputRequest;

public class LottoGameContoller {
    private final InputRequest inputRequest;

    public LottoGameContoller() {
        inputRequest = new InputRequest();
    }

    public void run() {
        ready();
    }

    private void ready() {
        String purchaseAmountInput = inputRequest.purchaseAmount();
    }
}
