package lotto.validation;

import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberValidatorTest {

    private final WinningNumberValidator validator = new WinningNumberValidator();

    @Test
    @DisplayName("당첨 번호가 빈 값일 때 예외 발생")
    void shouldThrowExceptionWhenWinningNumberIsEmpty() {
        assertThatThrownBy(() -> validator.validateNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WINNING_NUMBER_BLANK_INPUT.getMessage());
    }

    @Test
    @DisplayName("당첨 번호의 개수가 6개 미만일 때 예외 발생")
    void shouldThrowExceptionWhenWinningNumberSizeIsLessThanSix() {
        List<Integer> lottoNumbers = List.of(3, 12, 25, 8, 10);
        assertThatThrownBy(() -> validator.validateNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WINNING_NUMBER_SIZE_INSUFFICIENT.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 1~45 범위를 벗어난 숫자가 있을 때 예외 발생")
    void shouldThrowExceptionWhenWinningNumberOutOfRange() {
        List<Integer> lottoNumbers = List.of(3, 12, 25, 50, 8, 10);
        assertThatThrownBy(() -> validator.validateNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있을 때 예외 발생")
    void shouldThrowExceptionWhenWinningNumberContainsDuplicates() {
        List<Integer> lottoNumbers = List.of(3, 12, 25, 3, 8, 10);
        assertThatThrownBy(() -> validator.validateNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WINNING_NUMBER_DUPLICATE.getMessage());
    }
}
