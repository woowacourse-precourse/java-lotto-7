package lotto.domain;

import lotto.validate.Validator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Validator.validationDuplicate(numbers);
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public Set<Integer> getNumbers() {
        return new TreeSet<>(numbers);
    }

    @Override
    public String toString() {
        return new TreeSet<>(numbers).toString();
    }
}
