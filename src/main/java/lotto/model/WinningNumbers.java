package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.ErrorMessage.INPUT_VALUE_MUST_BE_NUMERIC;
import static lotto.constants.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.constants.ErrorMessage.INVALID_WINNING_NUMBER_COUNT;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_BLANK_AT_EDGES;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_DUPLICATED_NUMBERS;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_STARTING_WITH_COMMA;
import static lotto.constants.ErrorMessage.WINNING_NUMBERS_MUST_CONTAIN_COMMA;

public class WinningNumbers {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> winningNumbers;

    public WinningNumbers(String rawWinningNumbers) {
        validate(rawWinningNumbers);
        this.winningNumbers = parseNumeric(rawWinningNumbers);
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

    private void validate(String rawWinningNumbers) {
        validateStrip(rawWinningNumbers);
        validateComma(rawWinningNumbers);
        validateStartingWithComma(rawWinningNumbers);
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

    private List<Integer> parseNumeric(String rawWinningNumbers) {
        try {
            List<Integer> winningNumbers = Arrays.stream(rawWinningNumbers.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();
            validateAfterParsing(winningNumbers);
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_VALUE_MUST_BE_NUMERIC);
        }
    }

    private void validateAfterParsing(List<Integer> winningNumbers) {
        validateNumberCount(winningNumbers);
        validateNumbersInRange(winningNumbers);
        validateDuplicatedNumbers(winningNumbers);
    }

    private void validateDuplicatedNumbers(List<Integer> winningNumbers) {
        Set<Integer> set = new HashSet<>(winningNumbers);
        if (set.size() == winningNumbers.size()) {
            return;
        }
        throw new IllegalArgumentException(NOT_ALLOWED_DUPLICATED_NUMBERS);
    }

    private void validateNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() == LOTTO_NUMBER_COUNT) {
            return;
        }
        throw new IllegalArgumentException(INVALID_WINNING_NUMBER_COUNT);
    }

    private void validateNumbersInRange(List<Integer> winningNumbers) {
        winningNumbers.forEach((number) -> {
            if (isInRange(number)) {
                return;
            }
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        });
    }

    private boolean isInRange(Integer number) {
        return RANGE_START <= number && number <= RANGE_END;
    }
}