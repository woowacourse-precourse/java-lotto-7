package lotto.model;

import java.util.List;

public class WinningNumber {
    private final List<Integer> lottoWinningNumber;
    private final int bonusNumber;

    public WinningNumber(List<Integer> lottoWinningNumber, int bonusNumber) {
        this.lottoWinningNumber = lottoWinningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLottoWinningNumber() {
        return lottoWinningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
