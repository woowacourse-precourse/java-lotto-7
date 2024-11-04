package lotto.validator;

import lotto.enums.ExceptionMessage;
import lotto.enums.LottoValue;
import lotto.util.Converter;

import java.util.regex.Pattern;

public class LottoValidator implements  Validator{
    private static final Pattern LOTTO_NUMBER_FORMAT = Pattern.compile("^-?\\d+(,-?\\d+)*$");


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
        int min = LottoValue.MIN_RANGE_NUMBER.getValue();
        int max = LottoValue.MIN_RANGE_NUMBER.getValue();
        boolean hasInvalidNumber = Converter.toNumberList(input).stream()
                .anyMatch(number -> number < min || number > max);
        if (hasInvalidNumber) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }
    }

}
