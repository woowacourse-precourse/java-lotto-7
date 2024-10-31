package lotto.service;

import static lotto.model.rank.Rank.enoughCountToBeSecondRank;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.generator.LottoGenerator;
import lotto.model.money.Money;
import lotto.model.rank.DrawResultRankTable;
import lotto.model.rank.Rank;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos offerLottos(final Money money) {
        int count = money.calculatePurchasedLottoCount();
        return lottoGenerator.generate(count);
    }


    public DrawResultRankTable rankMyLottos(final Lottos lottos, final Lotto drawResult, final Integer bonusNumber) {

        DrawResultRankTable rankTable = DrawResultRankTable.initiate();

        lottos.initiateStream()
                .forEach(lotto -> {
                    Rank rank = rankEachLotto(lotto, drawResult, bonusNumber);
                    rankTable.updateResultRankTable(rank);
                });

        return rankTable;
    }

    private Rank rankEachLotto(final Lotto myLotto, final Lotto drawResult, final Integer bonusNumber) {

        int matchedCount = myLotto.countMatchedNumbersFrom(drawResult);
        boolean hasBonusNumber = false;

        if (enoughCountToBeSecondRank(matchedCount)) {
            hasBonusNumber = myLotto.has(bonusNumber);
        }

        return Rank.getRankBy(matchedCount, hasBonusNumber);
    }

}
