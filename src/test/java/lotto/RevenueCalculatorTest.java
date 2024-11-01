package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RevenueCalculatorTest {

    @BeforeEach
    void set_up() {
        Arrays.stream(WinningRank.values()).forEach(WinningRank::resetSuccessMatch);
    }

    @Test
    void 최종_수익률_계산() {
        int purchaseAmount = 50_000;
        WinningRank.of(3, false);
        WinningRank.of(5, true);

        assertThat(RevenueCalculator.revenueRate(purchaseAmount)).isEqualTo(60010);
    }

    @Test
    void 최종_수익률_소수점_둘째자리까지_표현() {
        int purchaseAmount = 160_000;
        WinningRank.of(3, false);

        assertThat(RevenueCalculator.revenueRate(purchaseAmount)).isEqualTo(3.13);
    }
}
