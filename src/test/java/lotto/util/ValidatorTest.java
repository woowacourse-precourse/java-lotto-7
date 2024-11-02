package lotto.util;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 입력 테스트")
    public void isEmptyInputTest(String input) {
        assertThatThrownBy(() -> Validator.isEmptyInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12test", "test", "123123abc"})
    @DisplayName("입력이 숫자가 아닌 문자로 구성되어 있는 확인")
    public void isDigitStringExceptionTest(String input) {
        assertThatThrownBy(() -> Validator.isDigitString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "10000", "20000"})
    @DisplayName("입력이 숫자로 구성되어 있을 때 정상동작 테스트")
    public void isDigitStringTest(String input) {
        assertThatNoException().isThrownBy(() -> Validator.isDigitString(input));
    }
}
