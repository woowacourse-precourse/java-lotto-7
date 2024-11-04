package lotto.application.validation;
import lotto.util.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoNumberValidatorTest {

    private final LottoNumberValidator validator = new LottoNumberValidator();

    @Test
    @DisplayName("유효한 로또 번호 입력 테스트")
    void validate_validInput_shouldReturnNumbers() {
        // Given
        String input = "1, 2, 3, 4, 5, 6";

        // When
        List<Integer> numbers = validator.validate(input);

        // Then
        assertNotNull(numbers);
        assertEquals(6, numbers.size());
        assertEquals(List.of(1, 2, 3, 4, 5, 6), numbers);
    }

    @Test
    @DisplayName("로또 번호 개수가 6개가 아닐 때 예외 발생 테스트")
    void validate_invalidNumberCount_shouldThrowException() {
        // Given
        String input = "1, 2, 3, 4, 5";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertEquals(ErrorMessages.INVALID_WINNING_NUMBER_COUNT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아닐 때 예외 발생 테스트")
    void validate_numberOutOfRange_shouldThrowException() {
        // Given
        String input = "1, 2, 3, 4, 5, 46";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertEquals(ErrorMessages.INVALID_WINNING_NUMBER_RANGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("로또 번호에 중복된 값이 있을 때 예외 발생 테스트")
    void validate_duplicateNumbers_shouldThrowException() {
        // Given
        String input = "1, 2, 3, 4, 5, 5";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertEquals(ErrorMessages.DUPLICATE_WINNING_NUMBER.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("로또 번호에 숫자가 아닌 값이 있을 때 예외 발생 테스트")
    void validate_nonNumericInput_shouldThrowException() {
        // Given
        String input = "1, 2, 3, 4, 5, a";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertEquals(ErrorMessages.INVALID_NUMBER_INPUT.getMessage(), exception.getMessage());
    }
}
