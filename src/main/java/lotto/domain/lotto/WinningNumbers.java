package lotto.domain.lotto;

import java.util.List;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank determineRank(Lotto lotto) {
        int matchCount = calculateMatchCount(lotto);
        boolean hasBonusNumber = matchCount == 5 && hasMatchingBonusNumber(lotto);
        return Rank.of(matchCount, hasBonusNumber);
    }

    private int calculateMatchCount(Lotto lotto) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto.getLotto()) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasMatchingBonusNumber(Lotto lotto) {
        return lotto.getLotto().contains(bonusNumber);
    }
}
