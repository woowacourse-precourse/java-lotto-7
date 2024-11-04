package lotto.model;

import static lotto.utils.Error.BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER;
import static lotto.utils.Error.BONUS_NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    void 보너스_번호가_1에서_45를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_OUT_OF_RANGE.getDescription());
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER.getDescription());
    }
}
