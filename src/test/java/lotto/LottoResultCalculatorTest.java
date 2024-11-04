package lotto;

import lotto.service.LottoRank;
import lotto.service.LottoResultCalculator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultCalculatorTest {

    @Test
    void 당첨_등수_결정_처리() {
        assertThat(LottoRank.determineRank(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.determineRank(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.determineRank(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.determineRank(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.determineRank(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.determineRank(2, false)).isEqualTo(LottoRank.NONE);
    }

    @Test
    void 총당첨금액_계산() {
        Map<LottoRank, Integer> rankCounts = Map.of(
                LottoRank.FIRST, 1,
                LottoRank.SECOND, 0,
                LottoRank.THIRD, 2,
                LottoRank.FOURTH, 1,
                LottoRank.FIFTH, 3
        );

        int totalPrize = LottoResultCalculator.calculateTotalPrize(rankCounts);
        assertThat(totalPrize).isEqualTo(
                1 * LottoRank.FIRST.getPrize() +
                        2 * LottoRank.THIRD.getPrize() +
                        1 * LottoRank.FOURTH.getPrize() +
                        3 * LottoRank.FIFTH.getPrize()
        );
    }

    @Test
    void 수익률_계산_처리() {
        int totalPrize = 2_150_000;
        int purchaseAmount = 10_000;
        double revenueRate = LottoResultCalculator.calculateRevenueRate(totalPrize, purchaseAmount);
        assertThat(revenueRate).isEqualTo(21500.0);
    }
}
