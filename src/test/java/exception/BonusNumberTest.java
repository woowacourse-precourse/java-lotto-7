package exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @DisplayName("숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void 숫자가_아닌_값이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 미만의 숫자가 입력되면 예외가 발생한다.")
    @Test
    void 일_미만의_숫자가_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("45 초과의 숫자가 입력되면 예외가 발생한다.")
    @Test
    void 사십오_초과의_숫자가_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}