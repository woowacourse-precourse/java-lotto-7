package lotto.utils;

import static lotto.utils.UnitConverter.convertUnit;
import static org.assertj.core.api.Assertions.assertThat;

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
        double profit = 10000.2;
        String answer = "10,000.2";

        assertThat(convertUnit(profit)).isEqualTo(answer);
    }
}
