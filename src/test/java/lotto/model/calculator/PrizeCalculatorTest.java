package lotto.model.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.model.rank.Rank;
import lotto.model.rank.RankResult;

public class PrizeCalculatorTest {

    @Test
    @DisplayName("등급에 따른 총 금액을 반환한다.")
    void shouldReturnTotalPrize() {
        RankResult rankResult = new RankResult();
        rankResult.addRank(Rank.FIFTH);
        rankResult.addRank(Rank.FOURTH);
        rankResult.addRank(Rank.SECOND);

        PrizeCalculator prizeCalculator = new PrizeCalculator();
        double totalPrize = prizeCalculator.calculate(rankResult);

        assertEquals(5_000 + 50_000 + 30_000_000, totalPrize);
    }

}
