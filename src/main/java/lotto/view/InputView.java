package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;

public class InputView {

    private InputView() {

    }

    public static String inputPurchaseAmount() {
        String input = inputWithValidation();
        return input;
    }

    public static String inputWinningNumbers() {
        String input = inputWithValidation();
        InputValidator.validateDelimitedByComma(input);
        return input;
    }

    public static String inputBonusNumber() {
        String input = inputWithValidation();
        return input;
    }

    private static String inputWithValidation() {
        String input = Console.readLine();
        InputValidator.validateNonBlank(input);
        return input;
    }
}


