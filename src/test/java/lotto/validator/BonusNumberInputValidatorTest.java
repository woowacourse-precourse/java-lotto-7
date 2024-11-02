package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberInputValidatorTest {

    @ParameterizedTest
    @DisplayName("보너스 번호가 공백 또는 null일 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " "})
    void throwsExceptionIsBlank(String bonus) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateAmount(bonus),
                "[ERROR] 값을 입력해주세요.");
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 양의 정수가 아닐 경우 예외가 발생한다.")
    @ValueSource(strings = {"abc", "0", "-2"})
    void throwsExceptionNotPositiveInteger(String bonus) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateAmount(bonus),
                "[ERROR] 양의 정수를 입력해주세요.");
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗어날 경우 예외가 발생한다.")
    void throwsExceptionOutOfRange() {
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateBonusNumber("46", List.of(1, 2, 3, 4, 5, 6)),
                "[ERROR] 1에서 45 사이의 숫자로 입력해주세요.");
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호에 중복될 경우 예외가 발생한다.")
    void throwsExceptionIsDuplicate() {
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateBonusNumber("1", List.of(1, 2, 3, 4, 5, 6)),
                "[ERROR] 중복되지 않는 숫자로 입력해주세요.");
    }

}
