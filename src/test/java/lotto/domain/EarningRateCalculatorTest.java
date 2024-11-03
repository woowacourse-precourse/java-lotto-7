package lotto.domain;

import lotto.domain.constant.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static lotto.domain.constant.Ranking.*;
import static org.assertj.core.api.Assertions.assertThat;

class EarningRateCalculatorTest {

    EarningRateCalculator earningRateCalculator;

    @BeforeEach
    void setUp() {
        earningRateCalculator = new EarningRateCalculator();
    }

    @Test
    void 당첨_통계에_따라_수익률을_계산한다() {
        //given
        int quantity = 10;

        EnumMap<Ranking, Integer> statistics = new EnumMap<>(Ranking.class);
        statistics.put(FIRST, 1);
        //when
        double earningRate = earningRateCalculator.calculateEarningRate(quantity, statistics);
        //then
        assertThat(earningRate).isEqualTo(20000000.0);
    }

    @Test
    void 당첨_통계에_따라_수익률을_계산한다2() {
        //given
        int quantity = 5;

        EnumMap<Ranking, Integer> statistics = new EnumMap<>(Ranking.class);
        statistics.put(FIFTH, 2);
        //when
        double earningRate = earningRateCalculator.calculateEarningRate(quantity, statistics);
        //then
        assertThat(earningRate).isEqualTo(200.0);
    }

    @Test
    void 당첨_통계에_따라_수익률을_계산한다3() {
        //given
        int quantity = 7;

        EnumMap<Ranking, Integer> statistics = new EnumMap<>(Ranking.class);
        statistics.put(THIRD, 1);
        statistics.put(FOURTH, 1);
        //when
        double earningRate = earningRateCalculator.calculateEarningRate(quantity, statistics);
        //then
        assertThat(earningRate).isEqualTo(22142.9);
    }
}