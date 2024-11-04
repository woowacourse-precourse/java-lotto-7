package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumberRange(numbers);
        validateNoDuplicateNumbers(numbers);
    }

    // TODO: 추가 기능 구현

    public boolean isContained(int number) {
        return numbers.contains(number);
    }

    public int getMatchCount(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContained)
                .count();
    }

    private List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = getSortedNumbers();
        return sortedNumbers.toString();
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > 45 || number < 0) {
                throw new IllegalArgumentException("[Error] 로또 번호의 범위는 1~45 입니다.");
            }
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
