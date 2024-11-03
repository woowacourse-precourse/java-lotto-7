package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {

    private InputView() {
    }

    public static String inputPurchaseAmount() {
        return getNumberInput();
    }

    public static String inputWinningNumber() {
        String input = Console.readLine().trim();
        InputValidator.validateWinningNumbers(input);
        return input;
    }

    public static String inputBonusNumber() {
        return getNumberInput();
    }

    private static String getNumberInput() {
        String input = Console.readLine().trim();
        InputValidator.validateInteger(input);
        return input;
    }
}
