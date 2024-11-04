package lotto.domain;

import java.util.Map;
import lotto.fixture.PrizeResultFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeResultTest {

    @Test
    @DisplayName("수익률을 계산한다")
    void calculate_return_with_price() {
        int price = 8000;

        Map<Prize, Integer> prizes = PrizeResultFixture.createTestPrizeResults();
        PrizeResult result = new PrizeResult(prizes);

        Assertions.assertEquals(result.calculateReturn(price), 62.5);
    }
}
