package lotto;

import java.util.List;

public class LottoResultChecker {
    public LottoResult checkResults(List<Lotto> lottos, WinningNumber winningNumber) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            Rank rank = checkRank(lotto, winningNumber);
            result.addResult(rank);
        }
        return result;
    }

    private Rank checkRank(Lotto lotto, WinningNumber winningNumber) {
        int matchedCount = (int) lotto.getNumbers().stream()
                .filter(winningNumber.getWinningNumbers()::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(winningNumber.getBonusNumber());

        // Rank 결정 로직 (enum Rank 사용)
        return Rank.findRank(matchedCount, bonusMatch);
    }
}
