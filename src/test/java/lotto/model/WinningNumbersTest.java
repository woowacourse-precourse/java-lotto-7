package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.exception.ErrorMessages.DUPLICATE_LOTTO_NUMBER_ERROR;
import static lotto.exception.ErrorMessages.INVALID_LOTTO_NUMBER_RANGE_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("당첨 번호가 1 이상 45 이하가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호가_1이상_45이하가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.from(Arrays.asList(46, 45, 1, 4, 3, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE_ERROR);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBER_ERROR);
    }
}