package lotto;

public class CommonValidation {
    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_VALUE_ERROR.getMessage());
        }
    }
}
