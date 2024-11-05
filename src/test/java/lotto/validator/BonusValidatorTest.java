package lotto.validator;

import lotto.enums.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusValidatorTest {

    private BonusValidator bonusValidator;

    @BeforeEach
    void setup() {
        bonusValidator = new BonusValidator();
    }

    @DisplayName("빈 칸이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateNull_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> bonusValidator.validate(input));
        assertEquals(ExceptionMessage.NOT_BLANK.getMessage(), exception.getMessage());
    }

    @DisplayName("0으로 시작하는 숫자일시, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "01000", "03000"})
    void validateNonZeroStart_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> bonusValidator.validate(input));
        assertEquals(ExceptionMessage.INVALID_ZERO_START.getMessage(), exception.getMessage());
    }

    @DisplayName("숫자가 아닌 다른 문자일시, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "aaa", "bbb", "10b3", "100!0"})
    void validateNumeric_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> bonusValidator.validate(input));
        assertEquals(ExceptionMessage.INVALID_NON_NUMERIC.getMessage(), exception.getMessage());
    }

    @DisplayName("범위를 초과하는 숫자 일시, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"46", "50", "100"})
    void validateRange_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> bonusValidator.validate(input));
        assertEquals(ExceptionMessage.OUT_OF_RANGE.getMessage(), exception.getMessage());
    }

}