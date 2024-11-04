package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final String TO_STRING_PREFIX = "[";
    private static final String TO_STRING_DELIMITER = ", ";
    private static final String TO_STRING_SUFFIX = "]";
    private static final int DELIMITER_SIZE = 2;
    public static final int MAX_SIZE = 6;
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = ascNumbers(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != MAX_SIZE) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_RANGE || number > MAX_RANGE)) {
            throw new IllegalArgumentException("로또 번호는 1에서 45 사이만 가능합니다.");
        }
    }

    private List<Integer> ascNumbers(List<Integer> numbers) {
        List<Integer> ascNumbers = new ArrayList<>(numbers);
        ascNumbers.sort(Integer::compareTo);
        return ascNumbers;
    }

    public List<Integer> numbers() {
        return List.copyOf(numbers);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TO_STRING_PREFIX)
                .append(attachNumbersWithDelimiter())
                .delete(sb.length() - DELIMITER_SIZE, sb.length())
                .append(TO_STRING_SUFFIX);
        return sb.toString();
    }

    private String attachNumbersWithDelimiter() {
        StringBuilder sb = new StringBuilder();
        numbers.forEach(number -> sb.append(number).append(TO_STRING_DELIMITER));
        return sb.toString();
    }

    public int correctCount(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean isBonus(int bonusNumber) {
        return numbers.stream().anyMatch(number -> number == bonusNumber);
    }
}