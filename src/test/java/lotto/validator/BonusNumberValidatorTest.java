package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {

    @Test
    @DisplayName("통과 검사1")
    void passTest1() {
        assertThat(BonusNumberValidator.validate("1"))
                .isTrue();
    }

    @Test
    @DisplayName("통과 검사2")
    void passTest2() {
        assertThat(BonusNumberValidator.validate("45"))
                .isTrue();
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력 검사")
    void notANumberTest() {
        assertThat(BonusNumberValidator.validate("a"))
                .isFalse();
    }

    @Test
    @DisplayName("유효한 범위 밖 숫자 검사1")
    void notValidNumber1() {
        assertThat(BonusNumberValidator.validate("46"))
                .isFalse();
    }

    @Test
    @DisplayName("유효한 범위 밖 숫자 검사2")
    void notValidNumber2() {
        assertThat(BonusNumberValidator.validate("0"))
                .isFalse();
    }

    @Test
    @DisplayName("유효한 범위 밖 숫자 검사3")
    void notValidNumber3() {
        assertThat(BonusNumberValidator.validate("-1"))
                .isFalse();
    }

    @Test
    @DisplayName("여러 개의 숫자 입력 검사")
    void inputNumbersTest() {
        assertThat(BonusNumberValidator.validate("1,2"))
                .isFalse();
    }

    @Test
    @DisplayName("공백 입력 검사")
    void noInputTest() {
        assertThat(BonusNumberValidator.validate(""))
                .isFalse();
    }
}