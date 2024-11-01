package lotto;

import lotto.io.InputMessage;
import lotto.io.InputReader;

public class LottoApplication {

    private final InputReader inputReader;

    public LottoApplication() {
        this.inputReader = new InputReader();
    }

    public void run() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        InputMessage.purchaseAmount();
        long purchaseAmount = inputReader.readPurchaseAmount();
    }

}
