package lotto;

import java.util.List;
import java.util.function.Predicate;

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

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getMatchingCount(List<Integer> winningNumber) {
        return Math.toIntExact(numbers.stream().filter(o -> winningNumber.stream().anyMatch(Predicate.isEqual(o))).count());
    }

    public boolean isMatchBonus(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
