package lotto.model;

import static lotto.ExceptionMessage.BONUS_NUMBER_DUPLICATE_EXCEPTION;
import static lotto.ExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @Test
    void 보너스_번호의_범위가_1부터_45_사이가_아니라면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(46, List.of(2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_OUT_OF_RANGE_EXCEPTION.message());
    }

    @Test
    void 보너스_번호는_당첨_번호와_중복이면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(3, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_DUPLICATE_EXCEPTION.message());
    }
}
