package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto numbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> numbers) {
        this.numbers = new Lotto(numbers);
    }
}
