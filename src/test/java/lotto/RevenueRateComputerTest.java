package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RevenueRateComputerTest {

    private RevenueRateComputer revenueRateComputer;

    @BeforeEach
    void 테스트_사전_작업() {
        revenueRateComputer = new RevenueRateComputer();
    }

    @DisplayName("수익률 계산이 소수점 둘째 자리에서 반올림을 잘 하는지 테스트")
    @Test
    void 수익률은_소수점_첫째자리_까지() {
        Assertions.assertThat(revenueRateComputer.computeRevenueRate(50000, 3))
                .isEqualTo(1666.7);
    }
}
