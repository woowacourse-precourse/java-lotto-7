package lotto.utils;

import static lotto.utils.UnitConverter.convertUnit;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UnitConverterTest {

    @Test
    @DisplayName("주어진 정수를 ,를 붙여 반환하는지 확인합니다.")
    void 자연수_단위_나누기_확인() {
        int number = 10_000_000;
        String answer = "10,000,000";

        assertThat(convertUnit(number)).isEqualTo(answer);
    }

    @Test
    @DisplayName("주어진 실수를 ,를 붙여 반환하는지 확인합니다.")
    void 실수_단위_나누기_확인() {
        BigDecimal profit = new BigDecimal("10000.2");
        String answer = "10,000.2";

        assertThat(convertUnit(profit)).isEqualTo(answer);
    }

    @Test
    @DisplayName("주어진 실수 마지막에 .0을 붙여 반환하는지 확인합니다.")
    void 실수_단위_나누기_확인2() {
        BigDecimal profit = new BigDecimal("10000.0");
        String answer = "10,000.0";

        assertThat(convertUnit(profit)).isEqualTo(answer);
    }
}
