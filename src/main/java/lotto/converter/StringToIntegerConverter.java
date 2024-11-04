package lotto.converter;

import lotto.enums.ErrorMessage;

public class StringToIntegerConverter {

    private StringToIntegerConverter() {
    }

    public static Integer convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER_INPUT.getMessage());
        }
    }
}
