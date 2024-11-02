package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.validation.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(Lotto winningLotto) {
        Set<Integer> winningNumbersSet = new HashSet<>(winningLotto.getNumbers());
        return (int) this.numbers.stream()
                .filter(winningNumbersSet::contains)
                .count();
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        Validation.checkLottoSize(numbers);
        Validation.isUniqueNumbers(numbers);
        numbers.forEach(Validation::checkLottoNumberRange);
    }
}
