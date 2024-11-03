package lotto;

import java.util.List;

public class LottoService {
    public LottoStatistics calculateStatistics(List<Lotto> lottos, List<Integer> winNumbers, Integer bonusNumber) {
        LottoStatistics statistics = new LottoStatistics();
        for (Lotto lotto : lottos) {
            LottoResult result = checkWinning(lotto, winNumbers, bonusNumber);
            statistics.recordWin(result);
        }
        return statistics;
    }

    public LottoResult checkWinning(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        int matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
        return determineResult(matchCount, lotto, bonusNumber);
    }

    private int countMatchingNumbers(List<Integer> numbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private LottoResult determineResult(int matchCount, Lotto lotto, Integer bonusNumber) {
        if (matchCount == 3) {
            return LottoResult.THREE_MATCH;
        }
        if (matchCount == 4) {
            return LottoResult.FOUR_MATCH;
        }
        if (matchCount == 5) {
            return lotto.getNumbers().contains(bonusNumber) ? LottoResult.FIVE_BONUS_MATCH : LottoResult.FIVE_MATCH;
        }
        if (matchCount == 6) {
            return LottoResult.SIX_MATCH;
        }
        return null;
    }


}
