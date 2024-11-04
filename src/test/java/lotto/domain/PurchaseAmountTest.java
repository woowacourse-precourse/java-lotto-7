package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.error.ErrorCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @Test
    void 구입금액_1000원_미만_실패() {
        assertThatThrownBy(() -> new PurchaseAmount("999"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.UNAVAILABLE_MIN_AMOUNT.getMessage());
    }

    @Test
    void 구입금액이_1000원의_배수_아니면_실패() {
        assertThatThrownBy(() -> new PurchaseAmount("1001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NOT_MULTIPLE_OF_1000.getMessage());
    }

    @ParameterizedTest(name = "{index}: \"{0}\"는 올바르지 않은 구입 금액입니다")
    @ValueSource(strings = {"1000.1", "A"})
    void 구입금액이_정수_범위_아니면_실패(String input) {
        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NOT_INTEGER.getMessage());
    }

    @Test
    void 정상적인_구입금액_성공() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("2000");
        assertEquals(2000, purchaseAmount.getAmount());
    }
}