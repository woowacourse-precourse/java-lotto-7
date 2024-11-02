package lotto.validator;

import lotto.enums.ExceptionMessage;
import lotto.util.Converter;

import java.util.regex.Pattern;

public class LottoValidator implements  Validator{
    private static final Pattern LOTTO_NUMBER_FORMAT = Pattern.compile("^-?\\d+(,-?\\d+)*$");
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    public void validate(String input) {
        validateNull(input);
        validateFormat(input);
        validateNumbersRange(input);
    }

    private void validateFormat(String input) {
        if (!LOTTO_NUMBER_FORMAT.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateNumbersRange(String input) {
        boolean hasInvalidNumber = Converter.toNumberList(input).stream()
                .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER);
        if (hasInvalidNumber) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }
    }

}
