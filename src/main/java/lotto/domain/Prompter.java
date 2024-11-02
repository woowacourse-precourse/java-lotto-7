package lotto.domain;

public class Prompter {
    private static final String INPUT_PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";

    public Prompter() {
    }

    public void showInputPurchaseAmountPrompt() {
        System.out.println(INPUT_PURCHASE_AMOUNT_GUIDE);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
