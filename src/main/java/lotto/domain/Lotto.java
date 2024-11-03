package lotto.domain;

import java.util.List;
import lotto.wrapper.BonusNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    public boolean matchesBonus(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getNumber());
    }

    public int matchCount(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
