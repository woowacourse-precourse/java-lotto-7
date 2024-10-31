package lotto.domain;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> filteredNumbers = new HashSet<>();
        filteredNumbers.addAll(numbers);
        if (filteredNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public int getEqualNumbersCount(Lotto other) {
        Set<Integer> filteredNumbers = new HashSet<>();
        filteredNumbers.addAll(numbers);
        int duplicateCount = 0;
        for (int number : other.numbers) {
            if (!filteredNumbers.add(number)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
}
