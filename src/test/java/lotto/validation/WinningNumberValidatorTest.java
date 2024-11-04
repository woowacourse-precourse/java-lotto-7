package lotto.validation;

import lotto.constatnt.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberValidatorTest {

    private final WinningNumberValidator validator = new WinningNumberValidator();

    @DisplayName("당첨 번호가 빈 값일 때 예외 발생")
    @Test
    void shouldThrowExceptionWhenWinningNumberIsEmpty() {
        assertThatThrownBy(() -> validator.validateNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WINNING_NUMBER_BLANK_INPUT.getMessage());
    }

    @DisplayName("당첨 번호의 개수가 6개 미만일 때 예외 발생")
    @Test
    void shouldThrowExceptionWhenWinningNumberSizeIsLessThanSix() {
        List<Integer> lottoNumbers = List.of(3, 12, 25, 8, 10);
        assertThatThrownBy(() -> validator.validateNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WINNING_NUMBER_SIZE_INSUFFICIENT.getMessage());
    }

    @DisplayName("당첨 번호에 1~45 범위를 벗어난 숫자가 있을 때 예외 발생")
    @Test
    void shouldThrowExceptionWhenWinningNumberOutOfRange() {
        List<Integer> lottoNumbers = List.of(3, 12, 25, 50, 8, 10);
        assertThatThrownBy(() -> validator.validateNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있을 때 예외 발생")
    @Test
    void shouldThrowExceptionWhenWinningNumberContainsDuplicates() {
        List<Integer> lottoNumbers = List.of(3, 12, 25, 3, 8, 10);
        assertThatThrownBy(() -> validator.validateNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WINNING_NUMBER_DUPLICATE.getMessage());
    }

    @DisplayName("보너스 번호가 빈 값일 때 예외 발생")
    @Test
    void shouldThrowExceptionWhenBonusNumberIsEmpty() {
        assertThatThrownBy(() -> validator.validateBonusNumber(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.BONUS_NUMBER_BLANK_INPUT.getMessage());
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어날 때 예외 발생")
    @Test
    void shouldThrowExceptionWhenBonusNumberOutOfRange() {
        assertThatThrownBy(() -> validator.validateBonusNumber("50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 발생")
    @Test
    void shouldThrowExceptionWhenBonusNumberIsDuplicateWithWinningNumber() {
        List<Integer> winningNumbers = List.of(3, 12, 25, 8, 10, 22);

        validator.validateNumbers(winningNumbers);

        assertThatThrownBy(() -> validator.validateBonusNumber("8"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.BONUS_NUMBER_DUPLICATE_WITH_WINNING.getMessage());
    }
}
