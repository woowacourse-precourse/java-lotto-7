package lotto.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BigDecimalTest {

    @Test
    void 나누어떨어지는경우_소수점없는지확인() {
        // given
        BigDecimal totalWinnings = BigDecimal.valueOf(5000);
        BigDecimal purchaseAmount = BigDecimal.valueOf(5000);

        // when
        String yield = totalWinnings
                .multiply(BigDecimal.valueOf(100))
                .divide(purchaseAmount, 1, RoundingMode.HALF_UP)
                .stripTrailingZeros()
                .toPlainString();

        // then
        assertThat(yield).isEqualTo("100");
    }

    @Test
    @DisplayName("HALF_UP 반올림 - 소수점 둘째 자리에서 반올림 확인")
    void 반올림_HALF_UP() {
        // given
        BigDecimal totalWinnings = BigDecimal.valueOf(5000);
        BigDecimal purchaseAmount = BigDecimal.valueOf(8000);

        // when
        String yield = totalWinnings
                .multiply(BigDecimal.valueOf(100))
                .divide(purchaseAmount, 1, RoundingMode.HALF_UP)
                .stripTrailingZeros()
                .toPlainString();

        // then
        assertThat(yield).isEqualTo("62.5");
    }
}