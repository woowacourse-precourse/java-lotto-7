package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final String TO_STRING_PREFIX = "[";
    private static final String TO_STRING_DELIMITER = ", ";
    private static final String TO_STRING_SUFFIX = "]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = ascNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> ascNumbers(List<Integer> numbers) {
        List<Integer> ascNumbers = new ArrayList<>(numbers);
        ascNumbers.sort(Integer::compareTo);
        return ascNumbers;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TO_STRING_PREFIX)
                .append(attachNumbersWithDelimiter())
                .delete(sb.length() - 2, sb.length())
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
