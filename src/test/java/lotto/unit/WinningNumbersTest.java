package lotto.unit;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ErrorMessages;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호가 6개가 아닌 경우 예외가 발생한다.")
    void winningNumbersSizeNotSix() {
        String input = "1,2,3,4,5";
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBER_COUNT);
    }

    @Test
    @DisplayName("당첨 번호에 중복된 값이 있는 경우 예외가 발생한다.")
    void winningNumbersContainDuplicates() {
        String input = "1,2,3,4,5,5";
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.DUPLICATE_WINNING_NUMBER);
    }
}
