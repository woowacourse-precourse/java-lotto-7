package service;

import static model.result.Rank.hasCountToBeSecond;

import model.lotto.Lotto;
import model.lotto.Lottos;
import model.result.Rank;
import model.result.RankResult;

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
}
