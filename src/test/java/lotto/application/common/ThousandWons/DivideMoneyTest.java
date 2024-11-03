package lotto.application.common.ThousandWons;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("ThousandWons - 금액 나눌 때")
public class DivideMoneyTest {

    @DisplayName("나누어 떨어지는 경우 정확한 몫 반환")
    @ParameterizedTest
    @CsvSource({
            "5000, 1000, 5",
            "5000, 2000, 2",
            "6000, 2000, 3"
    })
    void 나누어떨어지는_경우_몫_반환(String money, int divisor, int expected) {
        // given
        ThousandWons thousandWons = ThousandWons.of(money);

        // expect
        Assertions.assertThat(thousandWons.divide(divisor)).isEqualTo(expected);
    }

    @DisplayName("나누어 떨어지지 않는 경우 정수 몫만 반환")
    @Test
    void 나누어떨어지지_않는_경우_정수몫_반환() {
        // given
        ThousandWons money = ThousandWons.of("5000");

        // expect
        Assertions.assertThat(money.divide(3000)).isEqualTo(1);
    }

}
