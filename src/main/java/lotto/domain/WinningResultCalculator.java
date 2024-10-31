package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResultCalculator {

    public List<LottoResult> calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        List<LottoResult> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean hasBonus = lotto.containsBonusNumber(bonusNumber);
            Rank rank = Rank.getRank(matchCount, hasBonus);
            results.add(new LottoResult(rank));
        }

        return results;
    }

    public int calculateTotalWinnings(List<LottoResult> results) {
        return results.stream()
                .mapToInt(LottoResult::getWinnings)
                .sum();
    }

}