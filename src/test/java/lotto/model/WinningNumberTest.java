package lotto.model;

import lotto.exception.ErrorMessage;
import lotto.exception.InvalidWinningNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    @Test
    @DisplayName("입력된 문자열 형식이 유효하지 않은 경우 예외가 발생한다.")
    void exceptionWhenWinningNumberHasInvalidFormat() {
        String input1 = "1,2,3,4,5";

        assertThatThrownBy(() -> new WinningNumber(input1))
                .isInstanceOf(InvalidWinningNumbersException.class)
                .hasMessageContaining(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.getMessage());

        String input2 = "1,2,3,4,a,6";

        assertThatThrownBy(() -> new WinningNumber(input2))
                .isInstanceOf(InvalidWinningNumbersException.class)
                .hasMessageContaining(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.getMessage());

        String input3 = "1,2,3,4,5,,6";

        assertThatThrownBy(() -> new WinningNumber(input3))
                .isInstanceOf(InvalidWinningNumbersException.class)
                .hasMessageContaining(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.getMessage());
    }

    @Test
    @DisplayName("입력된 문자열을 기준으로 [1, 2, 3, 4, 5, 6] 형식의 당첨 번호로 변환한다.")
    void processingInput() {
        String input = "1,2,3,4,5,6";
        WinningNumber winningNumber = new WinningNumber(input);

        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(winningNumber.get()).isEqualTo(expectedNumbers);
    }

    @Test
    @DisplayName("1~45 범위를 벗어나는 숫자가 포함된 경우 예외가 발생한다.")
    void exceptionWhenWinningNumberHasInvalidRange() {
        String input = "1,2,3,4,5,46";

        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(InvalidWinningNumbersException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("중복된 숫자가 포함된 경우 예외가 발생한다.")
    void exceptionWhenWinningNumberHasDuplicate() {
        String input = "1,2,3,3,5,6";

        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(InvalidWinningNumbersException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_NUMBER_IS_NOT_ALLOWED.getMessage());
    }
}
