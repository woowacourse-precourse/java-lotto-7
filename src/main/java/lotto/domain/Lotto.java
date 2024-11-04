package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicated(numbers);
        checkValidRange(numbers);
    }

    private static void checkValidRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number > 45)
                .findAny()
                .ifPresent(invalidNumber -> {
                    throw new IllegalArgumentException("로또 번호는 45 이하 양수여야 합니다.");
                });
    }

    private static void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private static void checkDuplicated(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되면 안됩니다.");
        }
    }

    public List<Integer> getNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        getSorted(sortedNumbers);
        return sortedNumbers;
    }

    private void getSorted(List<Integer> sortedNumbers) {
        sortedNumbers.sort(Integer::compareTo);
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}