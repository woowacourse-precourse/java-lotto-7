package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getString() {
        return Console.readLine();
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
        return !input.matches("\\d+");
    }

    private void validateIntegerRange(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
