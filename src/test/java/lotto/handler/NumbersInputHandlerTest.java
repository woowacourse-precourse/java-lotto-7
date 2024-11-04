package lotto.handler;

import lotto.domain.LottoNumber;
import lotto.domain.lottoForm.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.message.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatCode;

public class NumbersInputHandlerTest {

    private final NumbersInputHandler numbersInputHandler = new NumbersInputHandler();

    @DisplayName("당첨 번호와 중복되지 않는 보너스 번호가 정상적으로 입력된 경우")
    @Test
    void bonusNumberSuccessTest() {
        // given
        int bonusNumber = 42;

        // when & then
        assertThatCode(() -> new LottoNumber(bonusNumber))
                .doesNotThrowAnyException();
    }


    @DisplayName("보너스 번호로 정수가 아닌 입력값이 들어오면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"3-23", "", "\n", " "})
    void nonIntegerExceptionTest(String nonInteger) {
        // when & then
        assertThatCode(() -> numbersInputHandler.convertToInteger(nonInteger))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NON_INTEGER_LOTTO.getMessage());
    }

    @DisplayName("보너스 번호로 로또 번호의 범위가 아닌 숫자가 들어오면 예외가 발생한다")
    @Test
    void numberScopeExceptionTest() {
        // given
        int nonValidScope = 46;

        // when & then
        assertThatCode(() -> new LottoNumber(nonValidScope))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_SCOPE_ERROR.getMessage());
    }

    @DisplayName("보너스 번호로 당첨 번호와 중복되는 숫자가 입력되면 예외가 발생한다")
    @Test
    void duplicateExceptionTest() {
        // given
        WinningNumbers winningNumbers = WinningNumbers.from("1,2,4,7,9,10");
        LottoNumber bonusNumber = new LottoNumber(4);

        // when & then
        assertThatCode(() -> winningNumbers.validateDuplicate(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_DUPLICATE.getMessage());
    }
}
