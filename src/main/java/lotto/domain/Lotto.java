package lotto.domain;

import java.util.List;

public class Lotto {
    private final Numbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public int countMatchNumbers(Numbers winNumbers) {
        return (int) numbers.getNumbers()
            .stream()
            .filter(number -> winNumbers.contains(number.value()))
            .count();
    }

    public boolean checkHasBonusNumber(Number bonusNumber) {
        return numbers.contains(bonusNumber.value());
    }
}
