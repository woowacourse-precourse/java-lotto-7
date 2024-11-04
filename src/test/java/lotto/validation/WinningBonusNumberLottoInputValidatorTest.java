package lotto.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.view.ErrorConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningBonusNumberLottoInputValidatorTest {

    private static final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("보너스 번호가 1에서 45 범위를 벗어나면 예외가 발생한다")
    @Test
    void 보너스번호가_범위를_벗어나면_예외가_발생한다() {
        // Given
        String input = "46";

        // When & Then
        assertThatThrownBy(() -> LottoInputValidator.validateBonusNumber(input, WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INVALID_BONUS_NUMBER_RANGE);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        // Given
        String input = "3";

        // When & Then
        assertThatThrownBy(() -> LottoInputValidator.validateBonusNumber(input, WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INVALID_BONUS_NUMBER_DUPLICATE);
    }

    @DisplayName("입력된 값이 숫자가 아닌 경우 예외가 발생한다")
    @Test
    void 입력값이_숫자가_아니면_예외가_발생한다() {
        // Given
        String input = "abc";

        // When & Then
        assertThatThrownBy(() -> LottoInputValidator.validateBonusNumber(input, WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INVALID_WINNING_NUMBER_FORMAT);
    }

    @DisplayName("유효한 보너스 번호 입력이 성공적으로 처리된다")
    @Test
    void 유효한_보너스번호_입력_성공() {
        // Given
        String input = "7";

        // When
        int result = LottoInputValidator.validateBonusNumber(input, WINNING_NUMBERS);

        // Then
        assertThat(result).isEqualTo(7);
    }
}
