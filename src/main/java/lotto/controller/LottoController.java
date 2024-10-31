package lotto.controller;

import lotto.io.Output;
import lotto.message.IOMessage;

public final class LottoController {
    public void run() {
        purchaseAmount();
    }

    public void purchaseAmount() {
        Output.printlnMessage(IOMessage.INPUT_PURCHASE_AMOUNT.getMessage());
    }
}
