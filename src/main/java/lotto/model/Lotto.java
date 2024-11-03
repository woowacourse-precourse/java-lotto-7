package lotto.model;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        sizeCheck(numbers);
        rangeCheck(numbers);
        duplicateCheck(numbers);
    }

    private void sizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void rangeCheck(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지의 정수여야 합니다.");
            }
        }
    }

    private void duplicateCheck(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호가 존재합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
