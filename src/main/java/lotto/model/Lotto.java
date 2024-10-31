package lotto.model;

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

    public int countMatchingNumber(WinningLotto winningLotto) {
        return winningLotto.countMatchingNumber(this.numbers);
    }
}
