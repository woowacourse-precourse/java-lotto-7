package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {
    private InputValidator validator;

    public String getMoney() {
        String input = Console.readLine();
        validator = new InputValidator(input);
        validator.validate();
        return input;
    }

    public String getWinningNumbers() {
        String input = Console.readLine();
        validator = new InputValidator(input);
        validator.validate();
        return input;
    }

    public String getBonusNumber() {
        String input = Console.readLine();
        validator = new InputValidator(input);
        validator.validate();
        return input;
    }
}
