package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ErrorMessages;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    void 시작과_끝부분에_구분자가_포함될_때_예외_발생() {
        // given
        String input = ",1,2,3,4,5,6,";

        // when & then
        assertThatThrownBy(() -> WinningNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.START_END_DELIMITER.formatMessage());
    }

    @Test
    void 구분자_사이에_공백이_포함될_때_예외_발생() {
        // given
        String input = "1, 2,3,4,5,6";

        // when & then
        assertThatThrownBy(() -> WinningNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.WHITESPACE_IN_DELIMITER.formatMessage());
    }

    @Test
    void 숫자와_쉼표_외의_문자가_포함될_때_예외_발생() {
        // given
        String input = "1,2,3,a,5,6";

        // when & then
        assertThatThrownBy(() -> WinningNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_CHARACTERS.formatMessage());
    }
}
