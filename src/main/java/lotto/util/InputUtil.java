package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
    static final String DELIMITER = ",";
    public String readInput() {
        String input = Console.readLine();
        Validator.validateNullInput(input);
        Validator.validateWhitespaceInput(input);
        return input;
    }
}
