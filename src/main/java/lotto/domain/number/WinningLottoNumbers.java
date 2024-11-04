package lotto.domain.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constants.ErrorMessage;

public class WinningLottoNumbers {
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final String DELIMITER = ",";

    private final List<Integer> numbers;

    public WinningLottoNumbers(List<Integer> numbers) {
        validate(new ArrayList<>(numbers));
        this.numbers = List.copyOf(numbers);
    }

    public static WinningLottoNumbers from(String input) {
        List<Integer> numbers = parseNumbers(input);
        return new WinningLottoNumbers(numbers);
    }

    private static List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbersRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_WINNING_NUMBERS_SIZE.getFormattedMessage(WINNING_NUMBERS_SIZE)
            );
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isInvalidRange)) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.getFormattedMessage(MIN_NUMBER, MAX_NUMBER)
            );
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(
                    ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage()
            );
        }
    }

    private boolean isInvalidRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
