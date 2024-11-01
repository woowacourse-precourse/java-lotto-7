package lotto.domain;

import java.util.List;

public class WinningNumber {

    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningNumber(final List<String> winningNumber, final String bonusNumber) {
        this.winningNumber = winningNumber.stream()
                .map(Integer::parseInt)
                .toList();
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getWinningNumber() {
        return this.winningNumber.stream().toList();
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
