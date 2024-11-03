package lotto.service;

public class Prompter {
    private static final String INPUT_PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_GUIDE = "보너스 번호를 입력해 주세요.";
    private static final String OUTPUT_PURCHASE_COUNT_NOTICE = "개를 구매했습니다.";

    public Prompter() {
    }

    public void showInputPurchaseAmountPrompt() {
        System.out.println(INPUT_PURCHASE_AMOUNT_GUIDE);
    }

    public void showOutputPurchaseCountPrompt(int count) {
        System.out.println(count + OUTPUT_PURCHASE_COUNT_NOTICE);
    }

    public void showInputWinningNumberPrompt() {
        System.out.println(INPUT_WINNING_NUMBER_GUIDE);
    }

    public void showInputBonusNumberPrompt() {
        System.out.println(INPUT_BONUS_NUMBER_GUIDE);
    }

    public void showBlankLine() {
        System.out.println();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
