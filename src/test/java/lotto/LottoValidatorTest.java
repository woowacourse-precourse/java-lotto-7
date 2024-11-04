package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {
    @Test
    void 구입_금액이_1000원_단위가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_6개가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_중복된_숫자가_있는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_1부터_45_사이의_정수가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
