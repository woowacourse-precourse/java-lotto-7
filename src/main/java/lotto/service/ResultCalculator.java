package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningNumbers;

public class ResultCalculator {
    public Map<Ranking, Integer> calculateResult(List<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Map<Ranking, Integer> results = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchNumbersCount = lotto.getMatchNumbersCount(winningNumbers);
            boolean bonusMatch = lotto.hasBonus(bonusNumber);

            Ranking ranking = Ranking.getRanking(matchNumbersCount, bonusMatch);
//            System.out.println(ranking);
            results.merge(ranking, 1, Integer::sum);
//            System.out.println(result);
        }
        return results;
    }
}
