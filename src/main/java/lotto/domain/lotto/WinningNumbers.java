package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validateDuplicate();
        validateSize();
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
    
    private void validateSize() {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate() {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(winningNumbers);
        uniqueNumbers.add(bonusNumber);
        if (uniqueNumbers.size() != 7) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }
}
