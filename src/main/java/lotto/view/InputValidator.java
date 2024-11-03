package lotto.view;

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
}
