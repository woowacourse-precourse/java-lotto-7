package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {
    @Test
    void 수익률_테스트() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        Map<LottoRank, Integer> statistics = new HashMap<>();
        statistics.put(LottoRank.FIFTH, 3);
        statistics.put(LottoRank.FIRST, 1);
        assertSimpleTest(() -> {
            assertThat(
                    profitCalculator.getProfit(100000, statistics)).isEqualTo(2000015.0);
        });
    }

    @Test
    void 수익률_테스트_작은수() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        Map<LottoRank, Integer> statistics = new HashMap<>();
        statistics.put(LottoRank.FIFTH, 3);
        assertSimpleTest(() -> {
            assertThat(
                    profitCalculator.getProfit(100000, statistics)).isEqualTo(15.0);
        });
    }

}