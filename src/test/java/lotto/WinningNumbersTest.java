package lotto;

import static lotto.exception.Exception.DUPLICATED_BONUS_NUMBERS;
import static lotto.exception.Exception.LOTTO_NUMBERS_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void 보너스_번호가_로또_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(DUPLICATED_BONUS_NUMBERS.getMessage());
    }

    @Test
    void 보너스_번호가_1부터_45_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 46)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
    }

    @Test
    void 로또_번호가_범위를_벗어나는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(0, 2, 3, 4, 5, 6), 7)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
    }

}