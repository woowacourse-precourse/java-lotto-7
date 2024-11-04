package lotto;

import java.util.List;

public class CompareBonusWinning {
    private final int bonusNumber;

    public CompareBonusWinning(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
    public boolean isBonusMatched(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
