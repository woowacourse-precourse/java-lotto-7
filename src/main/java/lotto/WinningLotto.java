package lotto;

import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(final List<Integer> numbers, final int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
}
