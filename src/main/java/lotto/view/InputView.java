package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {

    private InputView() {
    }

    public static String inputPurchaseAmount() {
        String input = Console.readLine().trim();
        InputValidator.validateInteger(input);
        return input;
    }
}
