package lotto.view;

import static lotto.common.config.Constants.MAX_NUMBER;
import static lotto.common.config.Constants.MIN_NUMBER;

public class InputValidator {
    private static final int unitPrice = 1000;
    private static final String numericPattern = "\\d+";

    public boolean isEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    public boolean isNumeric(String input) {
        return input.matches(numericPattern);
    }

    public boolean isIntegerRange(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isMultipleOfUnitPrice(String input) {
        return Integer.parseInt(input) % unitPrice == 0;
    }

    public boolean containsWhiteSpace(String input) {
        return input.contains(" ");
    }

    public boolean isNumberInLottoRange(String input) {
        int number = Integer.parseInt(input);
        return number >= MIN_NUMBER.getNumber() && number <= MAX_NUMBER.getNumber();
    }
}
