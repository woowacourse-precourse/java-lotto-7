package lotto.model.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.common.Error.NOT_DUPLICATED_NUMBER;
import static lotto.common.Error.OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {
    @Test
    void 범위를_넘어서면_예외가_발생한다() {
        assertThatThrownBy(() -> Bonus.from(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE.getMessage());
    }

    @Test
    void 중복된_숫자를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> Bonus.from(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DUPLICATED_NUMBER.getMessage());
    }
}