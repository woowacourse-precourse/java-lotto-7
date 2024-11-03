package lotto.domain.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("로또 번호는 최소 1 이상이다.")
    void 로또_번호는_최소_1_이상이다() {
        // Given
        int number = 1;

        // When
        LottoNumber lottoNumber = new LottoNumber(number);

        // Then
        assertThat(lottoNumber).isNotNull();
        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @Test
    @DisplayName("로또 번호는 최대 45 이하이다.")
    void 로또_번호는_최대_45_이하이다() {
        // Given
        int number = 45;

        // When
        LottoNumber lottoNumber = new LottoNumber(number);

        // Then
        assertThat(lottoNumber).isNotNull();
        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @Test
    @DisplayName("로또 번호가 1 미만이면 예외가 발생한다.")
    void 로또_번호가_1_미만이면_예외가_발생한다() {
        // Given
        int number = 0;

        // When
        ThrowingCallable throwable = () -> new LottoNumber(number);

        // Then
        assertThatThrownBy(throwable)
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 45 초과이면 예외가 발생한다.")
    void 로또_번호는_45_초과이면_오류가_발생한다() {
        // Given
        int number = 46;

        // When
        ThrowingCallable throwable = () -> new LottoNumber(number);

        // Then
        assertThatThrownBy(throwable)
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }
}