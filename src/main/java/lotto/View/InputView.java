package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;

public class InputView {
    public static int getMoneyToBuy() {
        while (true) {
            try {
                OutputView.notifyEnterMoneyToBuy();
                String input = Console.readLine();
                return validateMoneyToBuy(input);
            } catch (Exception e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static int validateMoneyToBuy(String input) {
        try {
            int moneyToBuy = Integer.parseInt(input); // 숫자가 아닌 경우 NumberFormatException 발생
            if (moneyToBuy <= 0) {
                throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_ERROR_MESSAGE.getMessage());
            }
            if (moneyToBuy % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_ERROR_MESSAGE.getMessage());
            }
            return moneyToBuy;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.getMessage(), e);
        }
    }
}
