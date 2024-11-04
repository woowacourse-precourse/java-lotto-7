package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberValidatorTest {

    @Test
    @DisplayName("로또 번호가 1~45 범위 내에 있는 경우 통과")
    void validateRange_validNumber_shouldPass() {
        assertThatCode(() -> LottoNumberValidator.validateRange(25))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호가 1보다 작은 경우 예외 발생")
    void validateRange_numberBelowMinimum_shouldThrowException() {
        assertThatThrownBy(() -> LottoNumberValidator.validateRange(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 45보다 큰 경우 예외 발생")
    void validateRange_numberAboveMaximum_shouldThrowException() {
        assertThatThrownBy(() -> LottoNumberValidator.validateRange(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
