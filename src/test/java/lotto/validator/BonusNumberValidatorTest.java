package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {
    private List<Integer> winningNumbers = List.of(10,20,30,40,41,42);

    @Test
    @DisplayName("통과 검사1")
    void passTest1() {
        assertThat(BonusNumberValidator.validate("1", winningNumbers))
                .isTrue();
    }

    @Test
    @DisplayName("통과 검사2")
    void passTest2() {
        assertThat(BonusNumberValidator.validate("45", winningNumbers))
                .isTrue();
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력 검사")
    void notANumberTest() {
        assertThat(BonusNumberValidator.validate("a", winningNumbers))
                .isFalse();
    }

    @Test
    @DisplayName("유효한 범위 밖 숫자 검사1")
    void notValidNumber1() {
        assertThat(BonusNumberValidator.validate("46" ,winningNumbers))
                .isFalse();
    }

    @Test
    @DisplayName("유효한 범위 밖 숫자 검사2")
    void notValidNumber2() {
        assertThat(BonusNumberValidator.validate("0", winningNumbers))
                .isFalse();
    }

    @Test
    @DisplayName("유효한 범위 밖 숫자 검사3")
    void notValidNumber3() {
        assertThat(BonusNumberValidator.validate("-1", winningNumbers))
                .isFalse();
    }

    @Test
    @DisplayName("여러 개의 숫자 입력 검사")
    void inputNumbersTest() {
        assertThat(BonusNumberValidator.validate("1,2", winningNumbers))
                .isFalse();
    }

    @Test
    @DisplayName("공백 입력 검사")
    void noInputTest() {
        assertThat(BonusNumberValidator.validate("", winningNumbers))
                .isFalse();
    }

    @Test
    @DisplayName("이미 당첨 번호에 있는 값 입력")
    void alreadyExistInWinningNumbersTest() {
        assertThat(BonusNumberValidator.validate("10", winningNumbers))
                .isFalse();
    }
}