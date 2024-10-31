package lotto.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThatThrownBy(() -> amountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> amountValidator.validate(input));
    }

    @DisplayName("1000단위가 아니라면, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"900", "1010", "20"})
    void validateUnit_throwsException(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> amountValidator.validate(input));
    }

    @DisplayName("0으로 시작하는 숫자일시, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings ={"0","01000","03000"})
    void validateNonZeroStart_throwsException(String input){
        assertThrows(IllegalArgumentException.class,() -> amountValidator.validate(input));
    }

    @DisplayName("숫자가 아닌 다른 문자일시, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings ={"a","aaa","bbb","10b3","100!0"})
    void validateNumeric_throwsException(String input){
        assertThrows(IllegalArgumentException.class, () -> amountValidator.validate(input));
    }


    @DisplayName("전체 통합 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "20000", "3000","50000"})
    void validateAmount_success(String input) {
        assertDoesNotThrow(() -> amountValidator.validate(input));
    }
}