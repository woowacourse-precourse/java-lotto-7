package lotto.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.view.ErrorConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersLottoInputValidatorTest {

    @DisplayName("정확히 6개의 숫자가 입력되지 않으면 예외가 발생한다")
    @Test
    void 숫자_개수가_6개가_아니면_예외가_발생한다() {
        // Given
        String input = "1,2,3,4,5";

        // When & Then
        assertThatThrownBy(() -> LottoInputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INVALID_WINNING_NUMBERS_COUNT);
    }

    @DisplayName("입력된 숫자가 1에서 45 범위를 벗어나면 예외가 발생한다")
    @Test
    void 숫자가_범위를_벗어나면_예외가_발생한다() {
        // Given
        String input = "0,2,3,4,5,6";

        // When & Then
        assertThatThrownBy(() -> LottoInputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INVALID_WINNING_NUMBER_RANGE);
    }

    @DisplayName("입력된 숫자에 중복이 있으면 예외가 발생한다")
    @Test
    void 중복된_숫자가_있으면_예외가_발생한다() {
        // Given
        String input = "1,2,3,4,5,5";

        // When & Then
        assertThatThrownBy(() -> LottoInputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INVALID_WINNING_NUMBER_DUPLICATE);
    }

    @DisplayName("입력된 값이 숫자가 아닌 경우 예외가 발생한다")
    @Test
    void 입력값이_숫자가_아니면_예외가_발생한다() {
        // Given
        String input = "1,2,3,4,5,abc";

        // When & Then
        assertThatThrownBy(() -> LottoInputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INVALID_WINNING_NUMBER_FORMAT);
    }

    @DisplayName("유효한 당첨 번호 입력이 성공적으로 처리된다")
    @Test
    void 유효한_당첨번호_입력_성공() {
        // Given
        String input = "1,2,3,4,5,6";

        // When
        List<Integer> result = LottoInputValidator.validateWinningNumbers(input);

        // Then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
