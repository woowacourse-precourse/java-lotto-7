package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public Prize match(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean bonusNumberIncluded = numbers.contains(bonusNumber);

        return Prize.valueOf(matchCount, bonusNumberIncluded);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto lotto)) {
            return false;
        }
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
