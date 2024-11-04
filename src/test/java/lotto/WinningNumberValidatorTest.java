package lotto;

import lotto.message.ErrorMessage;
import lotto.validator.WinningNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class WinningNumberValidatorTest {

    @Test
    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    void validateWinningNumberWithInvalidCount() {
        String[] winningNumbers = {"1", "2", "3", "4", "5"};

        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void validateWinningNumberWithDuplicates() {
        String[] winningNumbers = {"1", "2", "3", "4", "5", "5"};

        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 유효하지 않은 숫자가 있으면 예외가 발생한다.")
    void validateWinningNumberWithInvalidNumbers() {
        String[] winningNumbers = {"1", "2", "3", "4", "5", "46"};

        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
    }

    @Test
    @DisplayName("유효한 당첨 번호를 입력하면 검증에 성공한다.")
    void validateWinningNumberSuccessfully() {
        String[] winningNumbers = {"1", "2", "3", "4", "5", "6"};

        Set<Integer> result = WinningNumberValidator.validateWinningNumber(winningNumbers);

        assertThat(result).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호에 공백이 포함되어 있으면 예외가 발생한다.")
    void validateWinningNumberWithBlankSpace() {
        String[] winningNumbers = {"1", "2", "3", "4", "5", "6 7"};

        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_HAS_BLANK.getMessage());
    }
}
