package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

public class InputView {
    private static final String NUMBER_PATTERN = "\\+d";

    public String getString() {
        String input = Console.readLine();
        validateEmptyString(input);
        return input;
    }

    private void validateEmptyString(final String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }

    public int getInteger() {
        String input = getString();
        validateNumberFormat(input);
        validateIntegerRange(input);
        return Integer.parseInt(input);
    }

    private void validateNumberFormat(final String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotNumber(final String input) {
        return !input.matches(NUMBER_PATTERN);
    }

    private void validateIntegerRange(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
