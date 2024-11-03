package lotto.domain;

import lotto.domain.provider.NumberProvider;
import lotto.domain.validator.RangeValidator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(NumberProvider numberProvider, RangeValidator rangeValidator) {
        List<Integer> numbers = numberProvider.provide();
        validate(numbers, rangeValidator);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers, RangeValidator rangeValidator) {
        validateNumbers(numbers);
        validateEachNumber(numbers, rangeValidator);
        validateDuplication(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("로또 번호는 NULL 일 수 없습니다.");
        }

        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_SIZE + "개여야 합니다.");
        }
    }

    private void validateEachNumber(List<Integer> numbers, RangeValidator rangeValidator) {
        for (Integer number : numbers) {
            if (number == null) {
                throw new IllegalArgumentException("로또 번호는 null 을 포함할 수 없습니다.");
            }

            if (rangeValidator.outOfRange(number)) {
                throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자입니다. 잘못된 숫자 : " + number);
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public boolean hasNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> match(Lotto lotto) {
        List<Integer> matched = new ArrayList<>();
        for (Integer number : lotto.numbers) {
            if (this.hasNumber(number)) {
                matched.add(number);
            }
        }
        return matched;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(this.numbers);
    }
}
