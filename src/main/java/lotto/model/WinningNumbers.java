package lotto.model;

import java.util.Arrays;
import java.util.List;

import static lotto.constants.ErrorMessage.INPUT_VALUE_MUST_BE_NUMERIC;
import static lotto.constants.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.constants.ErrorMessage.INVALID_WINNING_NUMBER_COUNT;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_BLANK_AT_EDGES;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_STARTING_WITH_COMMA;
import static lotto.constants.ErrorMessage.WINNING_NUMBERS_MUST_CONTAIN_COMMA;

public class WinningNumbers {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final String rawWinningNumbers;

    public WinningNumbers(String rawWinningNumbers) {
        validate(rawWinningNumbers);
        this.rawWinningNumbers = rawWinningNumbers;
    }

    private void validate(String rawWinningNumbers) {
        validateStrip(rawWinningNumbers);
        validateComma(rawWinningNumbers);
        validateStartingWithComma(rawWinningNumbers);
        validateNumeric(rawWinningNumbers);
        validateNumberCount(rawWinningNumbers);
        validateNumbersInRange(rawWinningNumbers);
    }

    private void validateStrip(String rawWinningNumbers) {
        String stripped = rawWinningNumbers.strip();
        if (rawWinningNumbers.equals(stripped)) {
            return;
        }
        throw new IllegalArgumentException(NOT_ALLOWED_BLANK_AT_EDGES);
    }

    private void validateComma(String rawWinningNumbers) {
        if (rawWinningNumbers.contains(",")) {
            return;
        }
        throw new IllegalArgumentException(WINNING_NUMBERS_MUST_CONTAIN_COMMA);
    }

    private void validateStartingWithComma(String rawWinningNumbers) {
        char firstCharacter = rawWinningNumbers.charAt(0);
        if (firstCharacter == ',') {
            throw new IllegalArgumentException(NOT_ALLOWED_STARTING_WITH_COMMA);
        }
    }

    private void validateNumeric(String rawWinningNumbers) {
        try {
            List<String> winningNumbers = splitByComma(rawWinningNumbers);
            winningNumbers.forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_VALUE_MUST_BE_NUMERIC);
        }
    }

    private void validateNumberCount(String rawWinningNumbers) {
        List<String> winningNumbers = splitByComma(rawWinningNumbers);
        if (winningNumbers.size() == LOTTO_NUMBER_COUNT) {
            return;
        }
        throw new IllegalArgumentException(INVALID_WINNING_NUMBER_COUNT);
    }

    private void validateNumbersInRange(String rawWinningNumbers) {
        List<Integer> winningNumbers = splitByComma(rawWinningNumbers).stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        winningNumbers.forEach((number) -> {
            if (isInRange(number)) {
                return;
            }
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        });
    }

    private boolean isInRange(Integer number) {
        return RANGE_START <= number && RANGE_END <= number;
    }

    private List<String> splitByComma(String rawWinningNumbers) {
        return Arrays.stream(rawWinningNumbers.split(",")).toList();
    }
}
