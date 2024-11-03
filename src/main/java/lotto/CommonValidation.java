package lotto;

public class CommonValidation {
    public static int convertStringToInt(String input) {
        int numericValue;
        try {
            numericValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_VALUE_ERROR.getMessage());
        }
        return numericValue;
    }
}
