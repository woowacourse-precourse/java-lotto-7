package lotto.model;

import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLottoNumbers(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        return getMatchingNumbers(winningLotto).size();
    }

    private List<Integer> getMatchingNumbers(Lotto winningLotto) {
        return this.numbers.stream()
                .filter(o -> winningLotto.numbers.stream().anyMatch(Predicate.isEqual(o)))
                .collect(Collectors.toList());
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return this.numbers.stream()
                .anyMatch(number -> number == bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
