package lotto.domain.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("구입 금액이 1,000원보다 낮으면 예외가 발생한다.")
    void 구입_금액이_1000원보다_낮으면_예외가_발생한다() {
        // Given
        int value = 0;

        // When
        ThrowingCallable throwable = () -> new PurchaseAmount(value);

        // Then
        assertThatThrownBy(throwable)
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 1,000의 배수가 아니면 예외가 발생한다.")
    void 구입_금액이_1000의_배수가_아니면_예외가_발생한다() {
        // Given
        int value = 1100;

        // When
        ThrowingCallable throwable = () -> new PurchaseAmount(value);

        // Then
        assertThatThrownBy(throwable)
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }
}