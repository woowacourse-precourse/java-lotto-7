package lotto.view;

import lotto.enums.RequestMessage;

public class OutputView {
    private static final String ERROR_FORMAT = "[ERROR] ";

    public static void requestLotteryPurchaseAmount() {
        System.out.println(RequestMessage.LOTTO_AMOUNT.getMessage());
    }

    public static void requestLotteryWinningNumber() {
        System.out.println(RequestMessage.WINNING_NUMBER.getMessage());
    }

    public static void requestLotteryBonusNumber() {
        System.out.println(RequestMessage.BONUS_NUMBER.getMessage());
    }

    public void printErrorMessage(String errorMessage) {
        System.err.println(ERROR_FORMAT + errorMessage);
    }

}
