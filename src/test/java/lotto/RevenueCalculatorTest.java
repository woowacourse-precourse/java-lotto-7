package lotto;

import java.util.List;
import lotto.model.Rank;
import lotto.service.RevenueCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RevenueCalculatorTest {
    @Test
    void 당첨된_내역을_기준으로_수익률을_계산한다() {
        // given
        RevenueCalculator revenueCalculator = new RevenueCalculator();
        Integer count = 3000;
        List<Rank> ranks = List.of(Rank.FIFTH, Rank.FIRST, Rank.NONE);

        // when
        double revenueRate = revenueCalculator.calculate(ranks, count);

        // then
        Assertions.assertEquals(66666833.3, revenueRate);
    }
}
