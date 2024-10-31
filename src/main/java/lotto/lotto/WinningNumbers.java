package lotto.lotto;

import java.util.List;

public class WinningNumbers {

    private final Lotto winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = new Lotto(winningNumbers);
    }
}
