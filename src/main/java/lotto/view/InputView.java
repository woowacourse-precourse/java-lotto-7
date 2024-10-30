package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;
import lotto.validation.LottoNumberValidator;

public class InputView {

    public String inputPurchaseAmount() {
        String input = inputWithValidation();
        return input;
    }

    public String inputWinningNumbers() {
        String input = inputWithValidation();
        LottoNumberValidator.validateDelimitedByComma(input);
        return input;
    }

    private String inputWithValidation() {
        String input = Console.readLine();
        InputValidator.validateNonBlank(input);
        return input;
    }
}


