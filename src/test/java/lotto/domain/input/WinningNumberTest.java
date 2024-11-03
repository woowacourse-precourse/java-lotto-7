package lotto.domain.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("당첨 번호가 6자리보다 짧으면 예외가 발생한다")
    void 당첨_번호가_6자리보다_짧으면_예외가_발생한다() {
        // Given
        int[] value = new int[]{1, 2, 3, 4, 5};

        // When
        ThrowingCallable throwable = () -> new WinningNumber(value);

        // Then
        assertThatThrownBy(throwable)
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 6자리보다 길면 예외가 발생한다")
    void 당첨_번호가_6자리보다_길면_예외가_발생한다() {
        // Given
        int[] value = new int[]{1, 2, 3, 4, 5, 6, 7};

        // When
        ThrowingCallable throwable = () -> new WinningNumber(value);

        // Then
        assertThatThrownBy(throwable)
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 1보다 작으면 예외가 발생한다")
    void 당첨_번호가_1보다_작으면_예외가_발생한다() {
        // Given
        int[] value = new int[]{0, 2, 3, 4, 5, 6};

        // When
        ThrowingCallable throwable = () -> new WinningNumber(value);

        // Then
        assertThatThrownBy(throwable)
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 45보다 크면 예외가 발생한다")
    void 당첨_번호가_45보다_크면_예외가_발생한다() {
        // Given
        int[] value = new int[]{1, 2, 3, 4, 5, 46};

        // When
        ThrowingCallable throwable = () -> new WinningNumber(value);

        // Then
        assertThatThrownBy(throwable)
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 겹치면 예외가 발생한다")
    void 당첨_번호가_겹치면_예외가_발생한다() {
        // Given
        int[] value = new int[]{1, 2, 3, 4, 5, 5};

        // When
        ThrowingCallable throwable = () -> new WinningNumber(value);

        // Then
        assertThatThrownBy(throwable)
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }
}