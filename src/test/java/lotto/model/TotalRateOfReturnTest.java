package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TotalRateOfReturnTest {
    @Test
    @DisplayName("총 수익률은 소수점 둘째 자리에서 반올림된다.")
    void calculateTotalRateOfReturnWithDecimalTest() {
        TotalRateOfReturn totalRateOfReturn = new TotalRateOfReturn(5000, 8000);
        assertThat(totalRateOfReturn.get()).isEqualTo(62.5);
    }

    @Test
    @DisplayName("수익률이 큰 수를 가질 때에도 정확한 값을 반환한다.")
    void test() {
        TotalRateOfReturn totalRateOfReturn = new TotalRateOfReturn(2000000000, 5000);
        assertThat(totalRateOfReturn.get()).isEqualTo(40000000.0);
    }
}
