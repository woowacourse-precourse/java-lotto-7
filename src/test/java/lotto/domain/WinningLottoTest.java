package lotto.domain;

import static lotto.TestConstants.ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.validator.WinningLottoValidator;
import org.junit.jupiter.api.Test;

class WinningLottoValidatorTest {
    
    @Test
    void 당첨번호와_보너스번호가_정상적이면_예외가_발생하지_않는다() {
        assertThatNoException().isThrownBy(() ->
                WinningLottoValidator.validate(List.of(1, 2, 3, 4, 5, 6), 7)
        );
    }

    @Test
    void 당첨번호가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningLottoValidator.validate(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 당첨번호가_1에서_45범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningLottoValidator.validate(List.of(0, 2, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() -> WinningLottoValidator.validate(List.of(1, 2, 3, 4, 5, 46), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 당첨번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningLottoValidator.validate(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 보너스번호가_1에서_45범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningLottoValidator.validate(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() -> WinningLottoValidator.validate(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningLottoValidator.validate(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
