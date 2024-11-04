package lotto;

import java.util.List;

public class LottoGame {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public LottoGame(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }
}
