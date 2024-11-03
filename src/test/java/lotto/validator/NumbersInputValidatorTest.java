package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumbersInputValidatorTest {

    @Test
    @DisplayName("당첨 번호를 공백을 입력했을 경우 예외가 발생한다.")
    void throwsExceptionNumbersAreBlank() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumbers(List.of("", " ")),
                "[ERROR] 값을 입력해주세요.");
    }

    @ParameterizedTest
    @DisplayName("당첨 번호가 양의 정수가 아닐 경우 예외가 발생한다.")
    @ValueSource(strings = {"-1", "0", "-10"})
    void throwsExceptionNumbersAreNotPositive(String number) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumbers(List.of(number)),
                "[ERROR] 양의 정수를 입력해주세요.");
    }

    @Test
    @DisplayName("6개의 당첨 번호를 입력하지 않은 경우 예외가 발생한다.")
    void throwsExceptionNotSixNumbers() {
        List<String> numbers = List.of("1", "2", "3", "4", "5");
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumbers(numbers),
                "[ERROR] 6개의 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("당첨 번호가 범위를 벗어났을 경우 예외가 발생한다.")
    void throwsExceptionNumberOutOfRange() {
        List<String> numbers = List.of("1", "2", "3", "46", "5", "6");
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumbers(numbers),
                "[ERROR] 1에서 45 사이의 숫자로 입력해주세요.");
    }

    @Test
    @DisplayName("중복된 당첨 번호를 입력했을 경우 예외가 발생한다.")
    void throwsExceptionDuplicateNumbers() {
        List<String> numbers = List.of("1", "2", "3", "4", "5", "1");
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumbers(numbers),
                "[ERROR] 중복되지 않는 숫자로 입력해주세요.");
    }

}
