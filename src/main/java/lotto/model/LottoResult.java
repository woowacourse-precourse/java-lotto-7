package lotto.model;

import java.util.Arrays;
import java.util.List;

public class LottoResult {
    private List<LottoRanking> lottoRankingSet;

    private int totalPrice;

    public LottoResult() {
        this.lottoRankingSet = Arrays.asList(LottoRanking.values());
        this.totalPrice = 0;
    }

    public List<LottoRanking> getLottoRankingSet() {
        return lottoRankingSet;
    }

    public LottoResult winning(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            int countOfMatch = matchNumber(lotto, winningNumbers);
            boolean matchBonus = matchBonusNumber(lotto, bonusNumber);
            LottoRanking ranking = LottoRanking.valueOf(countOfMatch, matchBonus);
            addResult(lottoResult.getLottoRankingSet(), ranking);
        }

        return lottoResult;
    }

    private int matchNumber(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            if (isMatch(winningNumber, lotto)) matchCount++;
        }

        return matchCount;
    }

}
