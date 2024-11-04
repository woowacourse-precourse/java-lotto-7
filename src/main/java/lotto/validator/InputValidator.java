package lotto.validator;

import static lotto.common.ErrorMessage.INPUT_IS_NOT_BLANK;
import static lotto.common.ErrorMessage.INPUT_MONEY_IS_DIGIT;
import static lotto.common.ErrorMessage.LOTTO_NUMBER_RANGE;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputValidator {
    public static final String MONEY_NUMBER_REGEX = "^[1-9][0-9]*$";
    public static final String LOTTO_NUMBER_REGEX = "^[0-9]*$";

    public void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INPUT_IS_NOT_BLANK.getMessage());
        }
    }

    public void validateMoneyFormat(String input) {
        if (!Pattern.matches(MONEY_NUMBER_REGEX, input)) {
            throw new IllegalArgumentException(INPUT_MONEY_IS_DIGIT.getMessage());
        }
    }

    public void validateLottoNumbers(String[] rawNumbers) {
        Arrays.stream(rawNumbers).forEach(this::validateLottoNumber);
    }

    public void validateLottoNumber(String rawNumber) {
        if (!Pattern.matches(LOTTO_NUMBER_REGEX, rawNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
