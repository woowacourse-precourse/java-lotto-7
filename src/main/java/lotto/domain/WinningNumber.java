package lotto.domain;

import java.util.List;

public class WinningNumber {

    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningNumber(final List<Integer> winningNumber, final int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }
}
