package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import validation.InputValidator;

public class InputView {

    public String inputPurchaseAmount() {
        String input = inputWithValidation();
        return input;
    }

    private String inputWithValidation() {
        String input = Console.readLine();
        InputValidator.validateNonBlank(input);
        return input;
    }
}


