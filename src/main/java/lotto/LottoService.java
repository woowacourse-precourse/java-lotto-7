package lotto;

import java.util.List;

public class LottoService {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoService(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        int totalBonusNumber = 0;
        List<Integer> lottoNumbers = lotto.getNumbers();

        int totalWinningNumbers = countMatchingWinningNumbers(lottoNumbers, winningNumbers);

        if (totalWinningNumbers == 5) {
            if (isContainsBonusNumber(lottoNumbers, bonusNumber)) {
                totalBonusNumber = 1;
            }
        }
        return Rank.getRankByMatch(totalWinningNumbers, totalBonusNumber);
    }

    int countMatchingWinningNumbers(List<Integer> sourceNumbers, List<Integer> targetNumbers) {
        int count = 0;
        for (Integer targetNumber : targetNumbers) {
            if (sourceNumbers.contains(targetNumber)) {
                count++;
            }
        }
        return count;
    }

    boolean isContainsBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
