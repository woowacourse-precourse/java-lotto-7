package lotto.domain.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("로또 번호의 개수는 6개이다.")
    void 로또_번호의_개수는_6개이다() {
        // Given
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};

        // When
        Lotto lotto = new Lotto(numbers);

        // Then
        assertThat(lotto).isNotNull();
        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또는 올바른 출력 형식을 가진다.")
    void 로또는_올바른_출력_형식을_가진다() {
        // Given
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};

        // When
        Lotto lotto = new Lotto(numbers);

        // Then
        assertThat(lotto).isNotNull();
        assertThat(lotto.toString()).isNotEmpty()
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("로또 번호의 개수가 6보다 모자르면 예외가 발생한다.")
    void 로또_번호의_개수가_6개보다_모자르면_예외가_발생한다() {
        // Given
        int[] numbers = new int[]{1, 2, 3, 4, 5};

        // When
        ThrowingCallable throwable = () -> new Lotto(numbers);

        // Then
        assertThatThrownBy(throwable)
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        // Given
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7};

        // When
        ThrowingCallable throwable = () -> new Lotto(numbers);

        // Then
        assertThatThrownBy(throwable)
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // Given
        int[] numbers = new int[]{1, 2, 3, 4, 5, 5};

        // When
        ThrowingCallable throwable = () -> new Lotto(numbers);

        // Then
        assertThatThrownBy(throwable)
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
