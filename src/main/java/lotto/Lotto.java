package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        checkDuplicateNumber(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkDuplicateNumber(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 존재합니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Lotto lotto)) {
            return false;
        }
        return Objects.equals(numbers, lotto.numbers);
    }

    public Long matchCount(WinningLotto winningLotto) {
        return winningLotto.match(numbers);
    }

    public boolean matchBonus(WinningLotto winningLotto) {
        return winningLotto.containsBonus(numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
