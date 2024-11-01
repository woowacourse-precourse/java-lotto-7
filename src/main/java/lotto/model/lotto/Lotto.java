package lotto.model.lotto;

import java.util.List;

public class Lotto {
    protected final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchingNumberWith(WinningLotto winningLotto) {
        return winningLotto.countMatchingNumberWith(this.numbers);
    }

    public boolean isBonusNumberMatchedWith(WinningLotto winningLotto) {
        return winningLotto.isBonusNumberMatchedWith(this.numbers);
    }
}
