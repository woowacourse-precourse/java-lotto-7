package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final Lotto winningNumber;

    public WinningNumber(List<Integer> winningNumbers) {
        this.winningNumber = Lotto.from(winningNumbers);
    }
}
