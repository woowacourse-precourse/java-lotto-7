package lotto.domain;

public class LottoStatistics {
    private boolean isBonusNumberMatched(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
