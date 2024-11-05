package lotto.util;

import lotto.domain.Ranking;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class EarningRateCalculatorTest {

    @Test
    void calculateCase1Test() {
        // given
        int totalAmount = 1000; // 구매 금액
        Map<Ranking, Integer> map = Map.of(Ranking.FIRST, 1); // 1등 당첨 금액 : 2,000,000,000
        // when
        double calculated = EarningRateCalculator.calculate(totalAmount, map);
        // then
        assertThat(calculated).isEqualTo(200_000_000);
    }

    @Test
    void calculateCase2Test() {
        // given
        int totalAmount = 8000;
        Map<Ranking, Integer> map = Map.of(
                Ranking.FIFTH, 2,
                Ranking.NONE, 6
        );
        // when
        double calculated = EarningRateCalculator.calculate(totalAmount, map);
        // then
        assertThat(calculated).isEqualTo(125.0);
    }

    @Test
    void calculateCase3Test() {
        // given
        int totalAmount = 8000;
        Map<Ranking, Integer> map = Map.of(
                Ranking.FIFTH, 1,
                Ranking.NONE, 7
        );
        // when
        double calculated = EarningRateCalculator.calculate(totalAmount, map);
        // then
        assertThat(calculated).isEqualTo(62.5);
    }
}