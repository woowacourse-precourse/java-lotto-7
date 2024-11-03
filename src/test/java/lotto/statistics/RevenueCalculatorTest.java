package lotto.statistics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import java.util.Arrays;
import lotto.PurchaseAmount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RevenueCalculatorTest {

    @BeforeEach
    void set_up() {
        Arrays.stream(WinningRank.values()).forEach(WinningRank::resetSuccessMatch);
    }

    @AfterEach
    void 테스트_후_당첨_현황_초기화() {
        Arrays.stream(WinningRank.values()).forEach(WinningRank::resetSuccessMatch);
    }

    @Test
    void 최종_수익률_소수점_둘째자리까지_계산() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("8000");
        WinningRank.match(3, false);

        assertThat(RevenueCalculator.calculateRevenue(purchaseAmount)).isCloseTo(62.50, within(0.01));
    }
}
