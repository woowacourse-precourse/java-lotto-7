package lotto.view;

import lotto.enums.Message;

public class OutputView {

    public void printPurchaseAmountInputMessage() {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public void printWinningNumbersInputMessage() {
        System.out.println(Message.INPUT_WINNING_NUMBERS.getMessage());
    }

    public void printBonusNumberInputMessage() {
        System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
    }

    public void printPurchaseCount(int count) {
        String message = String.format(Message.PURCHASE_SUFFIX.getMessage(), count);
        System.out.println(message);
    }
}
