package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {
    private final InputValidator validator = new InputValidator();

    public String getPurchaseAmount() {
        String input = Console.readLine();
        validator.validateInputIsBlank(input);
        return input;
    }

    public String getWinningNumbers() {
        String input = Console.readLine();
        validator.validateInputIsBlank(input);
        return input;
    }

    public String getBonusNumber() {
        String input = Console.readLine();
        validator.validateInputIsBlank(input);
        return input;
    }
}
