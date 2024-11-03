package lotto.domain;

public class Prompter {
    private static final String INPUT_PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String OUTPUT_PURCHASE_COUNT_NOTICE = "개를 구매했습니다.";

    public Prompter() {
    }

    public void showInputPurchaseAmountPrompt() {
        System.out.println(INPUT_PURCHASE_AMOUNT_GUIDE);
    }

    public void showOutputPurchaseCountPrompt(int size) {
        System.out.println();
        System.out.println(size + OUTPUT_PURCHASE_COUNT_NOTICE);
    }

    public void showInputWinngNumberPrompt() {
        System.out.println(INPUT_WINNING_NUMBER_GUIDE);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
