package lotto.model.lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {
    @Test
    void 로또번호가_유효한_범위에_있으면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> LottoValidator.validate(List.of(1, 2, 3, 4, 5, 6)));
        assertDoesNotThrow(() -> LottoValidator.validate(List.of(10, 20, 30, 40, 41, 45)));
    }

    @Test
    void 로또번호가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validate(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");

        assertThatThrownBy(() -> LottoValidator.validate(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validate(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다.");
    }

    @Test
    void 로또번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validate(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> LottoValidator.validate(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}