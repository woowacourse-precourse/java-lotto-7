package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessages;

public class InputView {
    public static String getUserLotto() {
        return Console.readLine();
    }

    public static String getUserBonus() {
        String userBonusInput = Console.readLine();
        validateInt(userBonusInput);
        validateBlank(userBonusInput);
        return userBonusInput;
    }

    public static String getUserMoney() {
        String userMoneyInput = Console.readLine();
        validateBlank(userMoneyInput);
        validateInt(userMoneyInput);
        return userMoneyInput;
    }

    private static void validateBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_USER_INPUT.getMessage());
        }
    }

    private static void validateInt(String money) {
        if (!isInt(money)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DIGIT.getMessage());
        }
    }

    private static boolean isInt(String money) {
        try {
            Integer.parseInt(money);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
