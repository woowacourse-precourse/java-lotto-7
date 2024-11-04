package lotto.domain.rank;

import lotto.domain.entity.Lotto;
import lotto.domain.entity.Lottos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRankPrize {

    private static final Map<LottoRank, Integer> rankPayouts = new HashMap<>();

    private static final int FIRST_PRIZE = 2_000_000_000;
    private static final int SECOND_PRIZE = 30_000_000;
    private static final int THIRD_PRIZE = 1_500_000;
    private static final int FOURTH_PRIZE = 50_000;
    private static final int FIFTH_PRIZE = 5_000;

    static {
        rankPayouts.put(LottoRank.FIRST, FIRST_PRIZE);
        rankPayouts.put(LottoRank.SECOND, SECOND_PRIZE);
        rankPayouts.put(LottoRank.THIRD, THIRD_PRIZE);
        rankPayouts.put(LottoRank.FOURTH, FOURTH_PRIZE);
        rankPayouts.put(LottoRank.FIFTH, FIFTH_PRIZE);
    }

    public int calculateTotalPrize(final Lottos lottos) {
        return lottos.calculateTotalPrize(rankPayouts);
    }
}
