package lotto.validator;

import lotto.enums.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AmountValidatorTest {

    private AmountValidator amountValidator;

    @BeforeEach
    void setup() {
        amountValidator = new AmountValidator();
    }

    @DisplayName("빈칸이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateNull_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                        () -> amountValidator.validate(input));
        assertEquals(ExceptionMessage.NOT_BLANK.getMessage(), exception.getMessage());
    }

    @DisplayName("1000단위가 아니라면, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"900", "1010", "20"})
    void validateUnit_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> amountValidator.validate(input));

        assertEquals(ExceptionMessage.INVALID_MONEY_UNIT.getMessage(),exception.getMessage());
    }

    @DisplayName("0으로 시작하는 숫자일시, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings ={"0","01000","03000"})
    void validateNonZeroStart_throwsException(String input){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> amountValidator.validate(input));
        assertEquals(ExceptionMessage.INVALID_ZERO_START.getMessage(), exception.getMessage());
    }

    @DisplayName("숫자가 아닌 다른 문자일시, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings ={"a","aaa","bbb","10b3","100!0"})
    void validateNumeric_throwsException(String input){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> amountValidator.validate(input));
        assertEquals(ExceptionMessage.INVALID_NON_NUMERIC.getMessage(),exception.getMessage());
    }


    @DisplayName("전체 통합 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "20000", "3000","50000"})
    void validateAmount_success(String input) {
        assertDoesNotThrow(() -> amountValidator.validate(input));
    }
}