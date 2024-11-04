package lotto.util.validator;


import static lotto.common.Constants.LOTTO_NUMBERS_COUNT;
import static lotto.common.Constants.LOTTO_NUMBER_MAX;
import static lotto.common.Constants.LOTTO_NUMBER_MIN;
import static lotto.common.Constants.LOTTO_SEPARATOR;
import static lotto.util.ErrorMessage.DUPLICATE_WINNING_LOTTO;
import static lotto.util.ErrorMessage.INVALID_WINNING_LOTTO_BLANK;
import static lotto.util.ErrorMessage.INVALID_WINNING_LOTTO_COUNT;
import static lotto.util.ErrorMessage.INVALID_WINNING_LOTTO_FORMAT;
import static lotto.util.ErrorMessage.INVALID_WINNING_LOTTO_NATURAL_NUMBER;
import static lotto.util.ErrorMessage.INVALID_WINNING_LOTTO_RANGE;
import static lotto.util.ErrorMessage.INVALID_WINNING_LOTTO_SEPARATOR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoValidator implements Validator<String> {

    @Override
    public void validate(String input) {
        checkNullOrBlank(input);
        checkSeparator(input);
        List<Integer> numbers = parseNumbers(input);
        checkNumberCount(numbers);
        checkRange(numbers);
        checkDuplicate(numbers);
    }

    private void checkNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_WINNING_LOTTO_BLANK.getMessage());
        }
    }

    private void checkSeparator(String input) {
        if (!input.contains(LOTTO_SEPARATOR)) {
            throw new IllegalArgumentException(INVALID_WINNING_LOTTO_SEPARATOR.getMessage());
        }
    }

    private List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(LOTTO_SEPARATOR))
                    .map(String::trim)  // 각 요소의 앞뒤 공백 제거
                    .map(this::parseSingleNumber)  // 각 요소를 숫자로 변환
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_WINNING_LOTTO_FORMAT.getMessage());
        }
    }

    private int parseSingleNumber(String numStr) {
        if (numStr.isEmpty()) {
            throw new IllegalArgumentException(INVALID_WINNING_LOTTO_FORMAT.getMessage());
        }
        int number = Integer.parseInt(numStr);
        checkNaturalNumber(number);
        return number;
    }

    private void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_LOTTO_COUNT.getMessage());
        }
    }

    private void checkNaturalNumber(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(INVALID_WINNING_LOTTO_NATURAL_NUMBER.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException(INVALID_WINNING_LOTTO_RANGE.getMessage());
            }
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_LOTTO.getMessage());
        }
    }
}
