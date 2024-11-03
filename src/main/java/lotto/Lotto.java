package lotto;

import domain.winning.WinningLotto;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        LottoValidator.validate(numbers);
    }

    public int matchNumbers(WinningLotto winningLotto) {
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
