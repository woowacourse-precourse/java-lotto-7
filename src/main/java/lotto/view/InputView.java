package lotto.view;

import static lotto.message.SystemMessage.REQUEST_BONUS_NUMBER;
import static lotto.message.SystemMessage.REQUEST_PURCHASE_AMOUNT;
import static lotto.message.SystemMessage.REQUEST_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readPurchaseAmount() {
        return readLine(REQUEST_PURCHASE_AMOUNT.getMessage());
    }

    public String readWinningNumber() {
        return readLine(REQUEST_WINNING_NUMBERS.getMessage());
    }

    public String readBonusNumber() {
        return readLine(REQUEST_BONUS_NUMBER.getMessage());
    }

    private String readLine(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

}
