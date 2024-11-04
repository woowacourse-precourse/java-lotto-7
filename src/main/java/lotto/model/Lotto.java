package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateWinningOverlap(numbers);
        validateWinningRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningOverlap(List<Integer> winningNumbers) {
        Set<Integer> set = new HashSet<>(winningNumbers);

        if (set.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_OVERLAP.getMessage());
        }
    }

    private void validateWinningRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Integer> parseWinningNumbers(String input) {
        String[] numbersStr = input.split(",");
        List<Integer> winningNumber = new ArrayList<>();

        try {
            for (String numberStr : numbersStr) {
                winningNumber.add(Integer.parseInt(numberStr.trim())); // trim()은 공백을 제거합니다.
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_FORMAT.getMessage());
        }

        Collections.sort(winningNumber);

        return winningNumber;
    }
}
