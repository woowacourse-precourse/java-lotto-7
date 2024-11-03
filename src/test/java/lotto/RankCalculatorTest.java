package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankCalculatorTest {

    @Test
    void 수익률을_계산한다() {
        // given
        List<Rank> ranks = List.of(
                Rank._5TH_WINNER,
                Rank._4TH_WINNER,
                Rank._NOT_WINNER,
                Rank._NOT_WINNER,
                Rank._NOT_WINNER
        );

        // when
        RankCalculator rankCalculator = RankCalculator.from(ranks);
        double profit = rankCalculator.getProfit();
        System.out.println(profit);

        // then
        assertThat(profit).isEqualTo(11);
    }

}