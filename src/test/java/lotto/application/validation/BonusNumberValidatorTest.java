package lotto.application.validation;

import lotto.util.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BonusNumberValidatorTest {

    private final BonusNumberValidator validator = new BonusNumberValidator();

    @Test
    @DisplayName("유효한 보너스 번호 입력 테스트")
    void validate_validBonusNumber_shouldReturnNumber() {
        // Given
        String input = "7";

        // When
        int bonusNumber = validator.validate(input);

        // Then
        assertEquals(7, bonusNumber);
    }

    @Test
    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아닐 때 예외 발생 테스트")
    void validateBonusNumber_outOfRange_shouldThrowException() {
        // Given
        String input = "50";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertEquals(ErrorMessages.INVALID_BONUS_NUMBER_RANGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호에 숫자가 아닌 값이 있을 때 예외 발생 테스트")
    void validateBonusNumber_nonNumericInput_shouldThrowException() {
        // Given
        String input = "a";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertEquals(ErrorMessages.INVALID_BONUS_NUMBER_INPUT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 발생 테스트")
    void validateBonusNumber_duplicateWithWinningNumbers_shouldThrowException() {
        // Given
        String input = "7";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validateBonusNumber(input, winningNumbers));
        assertEquals(ErrorMessages.DUPLICATE_BONUS_NUMBER.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("유효한 보너스 번호와 당첨 번호 중복 검증 테스트")
    void validateBonusNumber_noOverlapWithWinningNumbers_shouldReturnNumber() {
        // Given
        String input = "8";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // When
        int bonusNumber = validator.validateBonusNumber(input, winningNumbers);

        // Then
        assertEquals(8, bonusNumber);
    }
}
