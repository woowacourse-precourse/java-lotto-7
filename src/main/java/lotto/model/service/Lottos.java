package lotto.model.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.NumberGenerator;
import lotto.model.domain.BonusBall;
import lotto.model.domain.Lotto;
import lotto.model.domain.Rank;
import lotto.model.domain.WinningBalls;

public class Lottos {

    private static final Long LOTTO_PRICE = 1_000L;
    private final List<Lotto> lottos;

    public static Lottos from(Long count, NumberGenerator numberGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> distinctNumbers = numberGenerator.generate();
            lottos.add(new Lotto(distinctNumbers));
        }
        return new Lottos(lottos);
    }

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public RankResult calculateWinningResults(WinningBalls winningBalls, BonusBall bonusBall) {
        RankResult rankResult = new RankResult();

        for (Lotto lotto : lottos) {
            Rank rank = calculateRankForLotto(lotto, winningBalls, bonusBall);
            rankResult.increaseRankCount(rank);
        }
        return rankResult;
    }

    private Rank calculateRankForLotto(Lotto lotto, WinningBalls winningBalls, BonusBall bonusBall) {
        int sameWinningCount = lotto.countDuplicatingCount(winningBalls.getLottoNumbers());
        int sameBonusCount = lotto.countDuplicatingCount(bonusBall.getLottoNumber());
        return Rank.valueOf(sameWinningCount, sameBonusCount);
    }

    public int getSize() {
        return this.lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public Long getTotalPrice() {
        return LOTTO_PRICE * getSize();
    }
}
