package lotto.view;

import static lotto.enums.ViewMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.enums.ViewMessage.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getLottoPurchaseAmount() {
        printPurchaseAmountMessage();
        return Console.readLine().trim();
    }

    private void printPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public String getWinningNumbers() {
        printWinningNumbersMessage();
        return Console.readLine().trim();
    }

    private void printWinningNumbersMessage() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
    }
}
