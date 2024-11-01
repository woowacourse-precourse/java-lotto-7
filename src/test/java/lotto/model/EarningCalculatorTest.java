package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EarningCalculatorTest {
    @Test
    void 수익률계산() {
        // given
        int[] winning = {1, 0, 0, 0, 0};
        int purchase = 8000;
        EarningCalculator earningCalculator = new EarningCalculator();
        // when
        System.out.println("=====Logic Start=====");

        double calculate = earningCalculator.calculate(winning, purchase);

        System.out.println("=====Logic End=====");
        // then
        assertThat(calculate).isEqualTo(62.5);

    }

    @Test
    void 당청금이커서int범위를넘었을경우_수익률계산() {
        // given
        int[] winning = {0, 0, 0, 0, 1};
        int purchase = 1000;
        EarningCalculator earningCalculator = new EarningCalculator();
        // when
        System.out.println("=====Logic Start=====");

        double calculate = earningCalculator.calculate(winning, purchase);

        System.out.println("=====Logic End=====");
        // then
        assertThat(calculate).isEqualTo(200000000);
    }

}