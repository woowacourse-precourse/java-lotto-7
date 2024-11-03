package lotto.service;

import static lotto.model.result.Rank.hasCountToBeSecond;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.money.Money;
import lotto.model.result.EarningsRate;
import lotto.model.result.Rank;
import lotto.model.result.RankResult;

public class ResultService {

    public ResultService() { }

    public RankResult getRankResult(Lottos lottos, Lotto winningLotto, int bonusNumber) {
        RankResult rankResult = RankResult.initiate();

        lottos.getLottos().forEach(lotto -> {
            Rank rank = getEachRank(lotto, winningLotto, bonusNumber);
            rankResult.compute(rank);
        });

        return rankResult;
    }

    private Rank getEachRank(final Lotto lotto, final Lotto winningLotto, final int bonusNumber) {
        int matchingCount = lotto.countMatch(winningLotto);
        boolean bonusMatched = false;

        if (hasCountToBeSecond(matchingCount)) {
            bonusMatched = lotto.hasBonus(bonusNumber);
        }

        return Rank.findRank(matchingCount, bonusMatched);
    }

    public EarningsRate getEarningsRate(RankResult rankResult, Money purchaseAmount) {
        Money totalPrize = rankResult.calculateTotalPrize();
        return EarningsRate.from(totalPrize, purchaseAmount);
    }
}
