package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.NumberValidator;
import lotto.util.StringValidator;

public class InputView {
    public String getString() {
        String input = Console.readLine();
        StringValidator.validateEmptyString(input);
        return input;
    }

    public int getInteger() {
        String input = getString();
        NumberValidator.validateNumberFormat(input);
        NumberValidator.validateIntegerRange(input);
        return Integer.parseInt(input);
    }
}
