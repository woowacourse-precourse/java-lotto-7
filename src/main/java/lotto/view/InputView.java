package lotto.view;

import static lotto.utils.NumberValidator.validateInt;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessages;

public class InputView {

    private InputView() {

    }

    public static String getUserLotto() {
        String userSixNumber = Console.readLine();
        validateBlank(userSixNumber);
        return userSixNumber;
    }

    public static String getUserBonus() {
        String userBonusInput = Console.readLine();
        validate(userBonusInput);
        return userBonusInput;
    }

    public static String getUserMoney() {
        String userMoneyInput = Console.readLine();
        validate(userMoneyInput);
        return userMoneyInput;
    }

    public static void validate(String userInput) {
        validateBlank(userInput);
        validateInt(userInput);
    }

    private static void validateBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_USER_INPUT.getMessage());
        }
    }
}
