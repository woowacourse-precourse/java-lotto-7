package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoSweepstakesTvShow {

    private final Map<Float, Integer> rateOfReturn = new HashMap<>();
    private final Map<Integer, Integer> matchResults;
    private final int bonusMatchCount;
    private final String winningStatistics  = "당첨 통계\n---";

    public LottoSweepstakesTvShow(Map<Integer, Integer> matchResults, int bonusMatchCount) {
        this.matchResults = matchResults;
        this.bonusMatchCount = bonusMatchCount;
    }

    public void printResults(Integer money) {
        System.out.println(winningStatistics);
        for (LottoPrizeDetail detail : LottoPrizeDetail.values()) {
            int count = getMatchCount(detail, matchResults, bonusMatchCount);
            System.out.println(detail.getDetailIntro() + " - " + count + "개");
            rateOfReturn.put(detail.getWinningPrizes(), count);
        }
        new CalculateRevenue(rateOfReturn, money);
    }

    private int getMatchCount(LottoPrizeDetail detail, Map<Integer, Integer> matchResults, int bonusMatchCount) {
        if (detail == LottoPrizeDetail.BONUS) {
            return bonusMatchCount;
        }
        return matchResults.getOrDefault(detail.getMatchNumber(), 0);
    }
}
