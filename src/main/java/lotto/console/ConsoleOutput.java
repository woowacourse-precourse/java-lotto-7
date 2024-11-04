package lotto.console;

import lotto.view.Output;

public class ConsoleOutput implements Output {

    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";

    @Override
    public void printPurchaseAmountPrompt() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
    }
}
