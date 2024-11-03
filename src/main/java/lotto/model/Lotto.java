package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
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
}
