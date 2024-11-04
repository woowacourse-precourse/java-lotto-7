package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @DisplayName("입력값이 1000 으로 나누어 떨어지지 않을떄 예외처리")
    @Test
    void 입력값_1000_나누어떨어지지_않을때() {
        assertThatThrownBy(() -> new PurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.CANT_PURCHASE_AMOUNT_DIVIDE_BY_1000.getMessage());
    }

    @DisplayName("입력값이 양수가 아닐 때 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-3"})
    void 입력값_양수_아닐때(String money) {
        assertThatThrownBy(() -> new PurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.PURCHASE_AMOUNT_MUST_BE_OVER_ZERO.getMessage());
    }

    @DisplayName("입력값이 수형식이 아닐 떄 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"hi", ":"})
    void 입력값_수형식_아닐때(String money) {
        assertThatThrownBy(() -> new PurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.CANT_CONVERT_TO_INTEGER.getMessage());
    }

}