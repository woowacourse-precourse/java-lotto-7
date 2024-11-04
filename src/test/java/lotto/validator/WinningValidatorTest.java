package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class WinningValidatorTest {

    @Test
    @DisplayName("콤마로 구분된 숫자 문자열이 숫자가 아닌 문자를 포함할 때 예외가 발생한다.")
    void givenNonNumericCharacters_whenValidateIsNumericWithCommas_thenThrowsException() {
        // given
        String input = "1,2,3,a,5,6";

        // when & then
        assertThatThrownBy(() -> WinningValidator.validateIsNumericWithCommas(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호의 개수가 6개가 아닐 경우 예외가 발생한다.")
    void givenInvalidCount_whenValidateWinningNumberCount_thenThrowsException() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> WinningValidator.validateWinningNumberCount(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닐 경우 예외가 발생한다.")
    void givenNonNumericBonusNumber_whenValidateBonusNumberIsNumeric_thenThrowsException() {
        // given
        String bonusNumber = "a";

        // when & then
        assertThatThrownBy(() -> WinningValidator.validateBonusNumberIsNumeric(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 유효한 범위를 벗어날 경우 예외가 발생한다.")
    void givenNumberOutOfRange_whenValidateNumberInRange_thenThrowsException() {
        // given
        int number = 50;

        // when & then
        assertThatThrownBy(() -> WinningValidator.validateNumberInRange(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("모든 당첨 번호가 유효한 범위 내에 있어야 한다.")
    void givenValidNumbers_whenValidateAllNumbersInRange_thenDoesNotThrowException() {
        // given
        List<Integer> validNumbers = List.of(1, 10, 20, 30, 40, 45);

        // when & then
        assertDoesNotThrow(() -> WinningValidator.validateAllNumbersInRange(validNumbers));
    }

    @Test
    @DisplayName("당첨 번호 리스트에 중복이 있을 경우 예외가 발생한다.")
    void givenDuplicateNumbers_whenValidateNoDuplicates_thenThrowsException() {
        // given
        List<Integer> numbersWithDuplicates = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> WinningValidator.validateNoDuplicates(numbersWithDuplicates))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    void givenDuplicateBonusNumber_whenValidateBonusNumberIsDuplicate_thenThrowsException() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 5;

        // when & then
        assertThatThrownBy(() -> WinningValidator.validateBonusNumberIsDuplicate(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
