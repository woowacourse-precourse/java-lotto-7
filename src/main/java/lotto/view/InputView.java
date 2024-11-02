package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumber;
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
        InputValidator.validateWinningNumbersSize(input);
        return input;
    }

    public String inputBonusNumber(WinningNumber winningNumber) {
        String input = inputWithValidation();
        BonusNumberValidator.validateRange(input);
        BonusNumberValidator.validateUniqueBonusNumber(winningNumber,input);
        return input;
    }

    private String inputWithValidation() {
        String input = Console.readLine();
        InputValidator.validateNonBlank(input);
        return input;
    }
}


