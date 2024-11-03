package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.enums.WinningType;
import org.junit.jupiter.api.Test;

public class TotalPriceTest {

    @Test
    void 투자_금액과_총_상금에_따라_수익률을_계산한다() {
        List<WinningType> winningStatistic = Arrays.asList(WinningType.FIFTH_PLACE);
        TotalPrice totalPrice = TotalPrice.sumAllPrice(winningStatistic);
        Money investmentMoney = new Money("8000");

        double expectedReturnRate = 62.5;
        double actualReturnRate = totalPrice.calculateReturnRate(investmentMoney);

        assertThat(actualReturnRate).isEqualTo(expectedReturnRate);
        System.out.println("결과:" + expectedReturnRate);
    }
}
