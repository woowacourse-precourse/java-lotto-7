package lotto.view;

import static lotto.resources.Constants.COMMA;
import static lotto.resources.Constants.CONTINUOUS_COMMA_REGEX;
import static lotto.resources.Constants.NUMBER_AND_COMMA_REGEX;
import static lotto.resources.Constants.ONLY_NUMBER_REGEX;
import static lotto.resources.ErrorMessages.INVALID_CONSECUTIVE_COMMAS;
import static lotto.resources.ErrorMessages.INVALID_EMPTY_OR_WHITESPACE;
import static lotto.resources.ErrorMessages.INVALID_END_WITH_COMMA;
import static lotto.resources.ErrorMessages.INVALID_NULL_INPUT;
import static lotto.resources.ErrorMessages.INVALID_NUMERIC_INPUT;
import static lotto.resources.ErrorMessages.INVALID_NUMERIC_OR_COMMA_INPUT;
import static lotto.resources.ErrorMessages.INVALID_START_WITH_COMMA;

import java.util.Arrays;
import java.util.List;
import lotto.domain.number.Numbers;

public class InputHandler {

    public int stringToNumber(final String input) {
        return Integer.parseInt(input);
    }

    public Numbers splitLottoNumbers(final String input) {
        List<Integer> lottoNumbers = Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .map(this::stringToNumber)
                .toList();

        return Numbers.of(lottoNumbers);
    }

    public void validateInputNumber(final String input) {
        noNull(input);
        noBlank(input);
        onlyInputNumber(input);
    }

    public void validateInputWinningNumbers(final String input) {
        noNull(input);
        noBlank(input);
        onlyInputNumberOrComma(input);
        noStartWithComma(input);
        noEndWithComma(input);
        hasNoContinuousComma(input);
    }

    private void noNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException(INVALID_NULL_INPUT.getMessage());
        }
    }

    private void noBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INVALID_EMPTY_OR_WHITESPACE.getMessage());
        }
    }

    private void onlyInputNumber(final String input) {
        if (!ONLY_NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NUMERIC_INPUT.getMessage());
        }
    }

    private void onlyInputNumberOrComma(final String input) {
        if (!NUMBER_AND_COMMA_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NUMERIC_OR_COMMA_INPUT.getMessage());
        }
    }

    private void noStartWithComma(final String input) {
        if (input.startsWith(",")) {
            throw new IllegalArgumentException(INVALID_START_WITH_COMMA.getMessage());
        }
    }

    private void noEndWithComma(final String input) {
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException(INVALID_END_WITH_COMMA.getMessage());
        }
    }

    private void hasNoContinuousComma(final String input) {
        if (CONTINUOUS_COMMA_REGEX.matcher(input).find()) {
            throw new IllegalArgumentException(INVALID_CONSECUTIVE_COMMAS.getMessage());
        }
    }
}
