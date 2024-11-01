package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.common.ErrorMessages;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    void 보너스번호가_null일때_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(null, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NULL_BONUS_NUMBER);
    }

    @Test
    void 보너스번호가_숫자가_아닐때_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("a", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_BONUS_NUMBER_INPUT_ERROR);
    }

    @Test
    void 보너스번호가_유효범위를_벗어날때_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("0", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_BONUS_NUMBER_RANGE);

        assertThatThrownBy(() -> new BonusNumber("46", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_BONUS_NUMBER_RANGE);
    }

    @Test
    void 보너스번호가_당첨번호와_중복될때_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("6", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.DUPLICATE_BONUS_NUMBER);
    }

    @Test
    void 유효한_보너스번호가_정상적으로_생성된다() {
        BonusNumber bonusNumber = new BonusNumber("7", List.of(1, 2, 3, 4, 5, 6));
        assertThat(bonusNumber.getNumber()).isEqualTo(7);
    }
}
