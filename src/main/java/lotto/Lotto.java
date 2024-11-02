package lotto;

import constants.ErrorMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        validateSize(numbers);
        checkDuplicate(numbers);
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCH_LOTTO_SIZE);
        }
    }

    private void checkDuplicate(List<LottoNumber> numbers) {
        if (new HashSet<>(numbers).size() < numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.EXISTS_DUPLICATE_NUMBER);
        }
    }

    public Long matchNumbers(WinningLotto winningLotto) {
        return winningLotto.countWinnings(numbers);
    }

    public boolean matchBonus(WinningLotto winningLotto) {
        return winningLotto.containsBonus(numbers);
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

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream().map(Object::toString).toList().toString();
    }
}
