package lotto.model;

import lotto.enumerate.Rank;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class EarningCalculatorTest {
    @Test
    void 수익률계산() {
        // given
        HashMap<Rank, Integer> currentLottoRank = new HashMap<>();
        currentLottoRank.put(Rank.FIFTH, 1);
        int purchase = 8000;
        // when
        System.out.println("=====Logic Start=====");

        double calculate = EarningCalculator.calculate(currentLottoRank, purchase);

        System.out.println("=====Logic End=====");
        // then
        assertThat(calculate).isEqualTo(62.5);
    }
}