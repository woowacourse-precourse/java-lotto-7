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
            return handleThreeMatches();
        }
        if (matchCount == 4) {
            return handleFourMatches();
        }
        if (matchCount == 5) {
            return handleFiveMatches(lotto, bonusNumber);
        }
        if (matchCount == 6) {
            return handleSixMatches();
        }
        return null;
    }

    private LottoResult handleThreeMatches() {
        return LottoResult.THREE_MATCH;
    }

    private LottoResult handleFourMatches() {
        return LottoResult.FOUR_MATCH;
    }

    private LottoResult handleFiveMatches(Lotto lotto, Integer bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return LottoResult.FIVE_BONUS_MATCH;
        }
        return LottoResult.FIVE_MATCH;
    }

    private LottoResult handleSixMatches() {
        return LottoResult.SIX_MATCH;
    }


}
