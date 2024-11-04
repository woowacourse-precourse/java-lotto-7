package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateNumbers(numbers);
    }

    public boolean hasSameNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int findMatchCount(Lotto userLotto) {
        int count = 0;
        for (Integer number : userLotto.numbers) {
            if (this.numbers.contains(number)) {
                count++;
            }

        }

        return count;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
