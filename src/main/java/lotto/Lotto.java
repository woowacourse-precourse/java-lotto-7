package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
