package lotto.validator;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class WinningNumbersValidatorTest {

    @Test
    @DisplayName("당첨 번호가 6개가 아닐 경우 예외가 발생한다.")
    void validateWinningNumbers_withInvalidSize() {
        List<Integer> invalidWinningNumbers = List.of(1, 2, 3, 4, 5); // 5개

        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_INVALID_NUMBER_COUNT.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 1부터 45 사이의 숫자가 아닌 경우 예외가 발생한다.")
    void validateWinningNumbers_withOutOfRangeNumber() {
        List<Integer> outOfRangeWinningNumbers = List.of(1, 2, 3, 4, 5, 46); // 46은 유효하지 않음

        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(outOfRangeWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void validateWinningNumbers_withDuplicateNumbers() {
        List<Integer> duplicateWinningNumbers = List.of(1, 2, 3, 4, 5, 5); // 중복된 5

        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(duplicateWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_DUPLICATE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    void validateBonusNumber_withOutOfRangeBonus() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6); // 정해진 당첨 번호
        int outOfRangeBonusNumber = 46; // 보너스 번호가 유효하지 않음

        assertThatThrownBy(() -> WinningNumbersValidator.validateBonusNumber(winningNumbers, outOfRangeBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void validateBonusNumber_withDuplicateWithWinningNumbers() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber = 6; // 당첨 번호와 중복

        assertThatThrownBy(() -> WinningNumbersValidator.validateBonusNumber(winningNumbers, duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
    }
}

