package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "0", "-123"})
    void checkIsNumericTure(String str) {
        // when
        boolean result = LottoGameValidator.checkIsNumeric(str);

        // then
        assertThat(result)
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j", "asd", "^d(fd"})
    void checkIsNumericFalse(String str) {
        // when
        Throwable throwable = catchThrowable(() -> {
            LottoGameValidator.checkIsNumeric(str);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_MUST_NUMERIC.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 0, 12000})
    void checkMoneyValidateTrue(int money) {
        // when
        boolean result = LottoGameValidator.checkMoneyValid(money);

        // then
        assertThat(result)
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1500, 50, 12001})
    @DisplayName("구입 금액이 1000으로 나눠떨어지지 않음")
    void checkIsNumericFalse_notDivided1000(int money) {
        // when
        Throwable throwable = catchThrowable(() -> {
            LottoGameValidator.checkMoneyValid(money);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INSERT_MONEY_NOT_DIVIDED_1000.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, -50000, -12000})
    @DisplayName("구입 금액이 음수임")
    void checkIsNumericFalse_minusMoney(int money) {
        // when
        Throwable throwable = catchThrowable(() -> {
            LottoGameValidator.checkMoneyValid(money);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MONEY_CAN_NOT_MINUS.getMessage());
    }
}
