package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constants.ErrorMessages;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    void 숫자가_아닌_값을_입력할_때_예외_발생() {
        // given
        String input = "abc";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> BonusNumber.from(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.NON_NUMERIC_VALUE.formatMessage());
    }

    @Test
    void 보너스_번호가_당첨번호와_중복될_때_예외_발생() {
        // given
        String input = "6";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> BonusNumber.from(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.DUPLICATE_WITH_WINNING_NUMBER.formatMessage());
    }

    @Test
    void 보너스_번호가_범위를_벗어날_때_예외_발생() {
        // given
        String input = "46";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> BonusNumber.from(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.BONUS_NUMBER_OUT_OF_RANGE.formatMessage());
    }
}
