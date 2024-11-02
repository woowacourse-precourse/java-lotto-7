package lotto.handler;

import lotto.domain.lottoForm.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.message.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatCode;

public class WinningNumbersInputHandlerTest {

    private final WinningNumbersInputHandler numbersInputHandler = new WinningNumbersInputHandler();

    @DisplayName("당첨 번호와 중복되지 않는 보너스 번호가 정상적으로 입력된 경우")
    @Test
    void bonusNumberSuccessTest() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,4,7,9,10");
        int bonusNumber = 42;

        // when & then
        assertThatCode(() -> winningNumbers.validateDuplicate(bonusNumber))
                .doesNotThrowAnyException();
    }


    @DisplayName("정수가 아닌 입력값이 들어오면 예외가 발생한다")
    @Test
    void nonIntegerExceptionTest() {
        // given
        String nonInteger = "3-23";

        // when & then
        assertThatCode(() -> numbersInputHandler.convertToInteger(nonInteger))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_INTEGER_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("로또 번호의 범위가 아닌 숫자가 들어오면 예외가 발생한다")
    @Test
    void numberScopeExceptionTest() {
        // given
        int nonValidScope = 46;

        // when & then
        assertThatCode(() -> numbersInputHandler.validateScope(nonValidScope))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_SCOPE_ERROR.getMessage());
    }

    @DisplayName("당첨 번호와 중복되는 보너스 번호가 입력되면 예외가 발생한다")
    @Test
    void duplicateExceptionTest() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,4,7,9,10");
        int bonusNumber = 4;

        // when & then
        assertThatCode(() -> winningNumbers.validateDuplicate(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATE.getMessage());
    }
}
