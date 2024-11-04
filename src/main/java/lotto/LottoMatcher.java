package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMatcher {
    private int threeMatchCount;
    private int fourMatchCount;
    private int fiveMatchCount;
    private int fiveWithBonusCount;
    private int sixMatchCount;

    public LottoMatcher() {
        this.threeMatchCount = 0;
        this.fourMatchCount = 0;
        this.fiveMatchCount = 0;
        this.fiveWithBonusCount = 0;
        this.sixMatchCount = 0;
    }

    public void checkLotto(List<Integer> winningNumbers, List<Integer> userLottoNumbers, int bonusNumber) {
        Set<Integer> uniqueWinningNumbers = new HashSet<>(winningNumbers);
        int matchCount = countMatchingNumbers(uniqueWinningNumbers, userLottoNumbers);

        if (matchCount == 3) {
            threeMatchCount++;
            return;
        }
        if (matchCount == 4) {
            fourMatchCount++;
            return;
        }
        if (matchCount == 5) {
            if (userLottoNumbers.contains(bonusNumber)) {
                fiveWithBonusCount++;
                return;
            }
            fiveMatchCount++;
            return;
        }
        if (matchCount == 6) {
            sixMatchCount++;
            return;
        }
    }

    private int countMatchingNumbers(Set<Integer> uniqueWinningNumbers, List<Integer> userLottoNumbers) {
        int matchCount = 0;

        for (Integer userLottoNumber : userLottoNumbers) {
            if (uniqueWinningNumbers.contains(userLottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public int[] getMatchCounts() {
        return new int[]{threeMatchCount, fourMatchCount, fiveMatchCount, fiveWithBonusCount, sixMatchCount};
    }
}
