package lotto.domain.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.validator.NumberValidator;
import lotto.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Test
    @DisplayName("당첨 번호를 입력받으면 List로 만드는지 테스트한다.")
    void createWinningNumberTest() {
        String inputWinningNumber = "1, 2, 3, 4, 5, 6";

        List<Integer> winningNumber = WinningNumber.create(inputWinningNumber);

        assertThat(winningNumber).hasSize(6);
    }

    @Test
    @DisplayName("당첨 번호가 6자리가 아니면 예외를 발생한다.")
    void winningNumbersTest1() {
        String winningNumbers = "1,2,3,4,5";

        assertThatThrownBy(() -> WinningNumber.create(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 중복되면 예외를 발생한다.")
    void winningNumbersTest2() {
        Validator numberValidator = new NumberValidator();
        String winningNumbers = "1,2,3,4,5,5";

        assertThatThrownBy(() -> WinningNumber.create(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 숫자가 아니면 예외를 발생한다.")
    void winningNumbersTest3() {
        String winningNumbers = "1,2,3,a,5,6";

        assertThatThrownBy(() -> WinningNumber.create(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 1 ~ 45 사이의 숫자가 아니면 예외를 발생한다.")
    void winningNumbersTest4() {
        String winningNumbers = "0,2,3,4,5,6";

        assertThatThrownBy(() -> WinningNumber.create(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}