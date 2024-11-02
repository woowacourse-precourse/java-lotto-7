package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.BonusNumberValidator;
import lotto.validation.InputValidator;

public class InputView {

    public String inputPurchaseAmount() {
        String input = inputWithValidation();
        return input;
    }

    public String inputWinningNumbers() {
        String input = inputWithValidation();
        InputValidator.validateDelimitedByComma(input);
        return input;
    }

    public String inputBonusNumber() {
        String input = inputWithValidation();
        BonusNumberValidator.validateRange(input);
        return input;
    }

    private String inputWithValidation() {
        String input = Console.readLine();
        InputValidator.validateNonBlank(input);
        return input;
    }
}


