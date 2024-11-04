package lotto.domain;

import lotto.domain.constant.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static lotto.domain.constant.Ranking.*;
import static org.assertj.core.api.Assertions.assertThat;

class EarningRateCalculatorTest {

    EarningRateCalculator earningRateCalculator;
    EnumMap<Ranking, Integer> statistics;


    @BeforeEach
    void setUp() {
        earningRateCalculator = new EarningRateCalculator();
        statistics = new EnumMap<>(Ranking.class);
    }

    @Test
    void 로또_10장으로_1등에_당첨되면_아래의_수익률을_반환한다() {
        //given
        int quantity = 10;

        statistics.put(FIRST, 1);
        //when
        double earningRate = earningRateCalculator.calculateEarningRate(quantity, statistics);
        //then
        assertThat(earningRate).isEqualTo(20000000.0);
    }

    @Test
    void 로또_5장으로_2등에_당첨되면_아래의_수익률을_반환한다() {
        //given
        int quantity = 5;

        statistics.put(FIFTH, 2);
        //when
        double earningRate = earningRateCalculator.calculateEarningRate(quantity, statistics);
        //then
        assertThat(earningRate).isEqualTo(200.0);
    }

    @Test
    void 로또_7장으로_3등과_4등에_당첨되면_아래의_수익률을_반환한다() {
        //given
        int quantity = 7;

        statistics.put(THIRD, 1);
        statistics.put(FOURTH, 1);
        //when
        double earningRate = earningRateCalculator.calculateEarningRate(quantity, statistics);
        //then
        assertThat(earningRate).isEqualTo(22142.9);
    }

    @Test
    void 로또_14장으로_4등과_5등에_당첨되면_아래의_수익률을_반환한다() {
        //given
        int quantity = 14;

        statistics.put(FOURTH, 1);
        statistics.put(FIFTH, 3);
        //when
        double earningRate = earningRateCalculator.calculateEarningRate(quantity, statistics);
        //then
        assertThat(earningRate).isEqualTo(464.3);
    }
}