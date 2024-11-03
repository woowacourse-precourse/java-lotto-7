package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.util.AddBonusNumber;
import lotto.domain.util.CreateWinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidatorTest {

    @Test
    @DisplayName("당첨 번호가 6자리가 아니면 예외를 발생한다.")
    void winningNumbersTest1() {
        Validator validator = new NumberValidator();
        String winningNumbers = "1,2,3,4,5";

        assertThatThrownBy(() -> validator.validate(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 중복되면 예외를 발생한다.")
    void winningNumbersTest2() {
        Validator validator = new NumberValidator();
        String winningNumbers = "1,2,3,4,5,5";

        assertThatThrownBy(() -> validator.validate(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 숫자가 아니면 예외를 발생한다.")
    void winningNumbersTest3() {
        Validator validator = new NumberValidator();
        String winningNumbers = "1,2,3,a,5,6";

        assertThatThrownBy(() -> validator.validate(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 1 ~ 45 사이의 숫자가 아니면 예외를 발생한다.")
    void winningNumbersTest4() {
        Validator validator = new NumberValidator();
        String winningNumbers = "0,2,3,4,5,6";

        assertThatThrownBy(() -> validator.validate(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 숫자가 아니면 예외를 발생한다.")
    @ValueSource(strings = {"a", "?", "1.3", "가", "1a"})
    void bonusNumberTest1(String number) {
        Validator validator = new NumberValidator();

        assertThatThrownBy(() -> validator.validate(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아니면 예외를 발생한다.")
    void bonusNumberTest2() {
        Validator validator = new NumberValidator();
        String bonusNumber = "46";

        assertThatThrownBy(() -> validator.validate(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}