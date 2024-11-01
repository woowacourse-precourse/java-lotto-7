package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberValidatorTest {

    @Test
    @DisplayName("똑바로 된 입력 검사1")
    void trueTest1() {
        assertThat(WinningNumberValidator.validate("1,2,3,4,5,6"))
                .isTrue();
    }

    @Test
    @DisplayName("똑바로 된 입력 검사2")
    void trueTest2() {
        assertThat(WinningNumberValidator.validate("1,2,3,4,5,45"))
                .isTrue();
    }

    @Test
    @DisplayName("공백 입력 검사")
    void validateTest() {
        assertThat(WinningNumberValidator.validate(""))
                .isFalse();
    }

    @Test
    @DisplayName("숫자 중복 검사")
    void duplicationTest() {
        assertThat(WinningNumberValidator.validate("1,2,3,4,5,5"))
                .isFalse();
    }

    @Test
    @DisplayName("구분자 개수 오류 검사")
    void delimiterCountTest() {
        assertThat(WinningNumberValidator.validate("1,2,3,4,5,6,"))
                .isFalse();
    }

    @Test
    @DisplayName("유효하지 않은 범위의 당첨번호 검사1")
    void notValidRangeTest1() {
        assertThat(WinningNumberValidator.validate("0,1,2,3,4,5"))
                .isFalse();
    }

    @Test
    @DisplayName("유효하지 않은 범위의 당첨번호 검사2")
    void notValidRangeTest2() {
        assertThat(WinningNumberValidator.validate("1,2,3,4,5,46"))
                .isFalse();
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력 검사")
    void notANumberTest() {
        assertThat(WinningNumberValidator.validate("a,1,2,3,4,5"))
                .isFalse();
    }
    @Test
    @DisplayName("6개를 초과한 값 입력 검사")
    void overSixIntegerTest() {
        assertThat(WinningNumberValidator.validate("1,2,3,4,5,6,7"))
                .isFalse();
    }

}