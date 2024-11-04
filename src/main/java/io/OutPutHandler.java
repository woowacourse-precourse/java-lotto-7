package io;

public class OutPutHandler {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void showInputPriceMessage() {
        System.out.println();
        System.out.println(INPUT_PRICE_MESSAGE);
    }

    public void showInputWinningNumbersMessage() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void showInputBonusNumberMessage() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }
}
