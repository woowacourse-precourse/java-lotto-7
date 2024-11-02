package lotto.model;

import java.util.List;

public class LottoWinningNumber {
    private final List<Integer> lottoWinningNumber;
    private final int bonusNumber;

    public LottoWinningNumber(List<Integer> lottoWinningNumber, int bonusNumber) {
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
