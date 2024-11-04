package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @DisplayName("로또 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_숫자가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateLottoNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 올바른_숫자가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateRightNumber("0001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구분자의 위치가 올바르지 않은 경우 예외가 발생한다.")
    @Test
    void 구분자의_위치가_올바르지_않은_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateRightDelimiter("12,3,4,"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
