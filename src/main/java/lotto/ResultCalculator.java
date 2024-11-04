package lotto;

import java.util.List;

public class ResultCalculator {
    private final LottoMatcher lottoMatcher;

    public ResultCalculator(LottoMatcher lottoMatcher) {
        this.lottoMatcher = lottoMatcher;
    }

    public int[] calculateResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] result = new int[Rank.values().length];
        for (Lotto lotto : lottos) {
            // 맞은갯수 계산
            int matchCount = lottoMatcher.countMatches(winningNumbers, lotto);
            // 보너스 검증
            boolean hasBonus = false;
            if (matchCount == 5) {
                hasBonus = lottoMatcher.bonusMatch(bonusNumber, lotto);
            }
            // 등수 계산
            Rank rank = Rank.getRank(matchCount, hasBonus);
            result[rank.ordinal()]++;
        }
        return result;
    }

    public float calculateProfit(int[] result, int payment) {
        int totalReward = 0;
        for (Rank rank : Rank.values()) {
            totalReward += rank.getReward() * result[rank.ordinal()];
        }

        float profit = ((float) totalReward / payment) * 100;
        return Math.round(profit * 10) / 10.0f;

    }

}
