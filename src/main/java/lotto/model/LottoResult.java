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

    public int matchNumber(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            if (isMatch(winningNumber, lotto)) matchCount++;
        }

        return matchCount;
    }

    public boolean isMatch(int winningNumber, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        for (Integer number : numbers) {
            if (number == winningNumber) return true;
        }

        return false;
    }

    public boolean matchBonusNumber(Lotto lotto, int bonusNumber) {
        for (Integer number : lotto.getNumbers()) {
            if (number == bonusNumber) {
                return true;
            }
        }

        return false;
    }

    public void addResult(List<LottoRanking> lottoRankingSet, LottoRanking ranking) {
        for (LottoRanking lottoRanking : lottoRankingSet) {
            if (lottoRanking.equals(ranking)) {
                totalPrice += lottoRanking.getWinningAmount();
                ranking.win();
            }
        }
    }

    public double getProfitRate(int purchase) {
        double result = ((double) totalPrice / purchase) * 100;
        return Math.round(result * 10) / 10.0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
