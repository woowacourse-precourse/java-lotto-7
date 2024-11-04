package lotto.domain;

import lotto.domain.lottoForm.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.message.ErrorMessage.*;

public class WinningNumbersTest {

    @DisplayName("정상적인 당첨 번호가 입력된 경우 성공 테스트")
    @Test
    void createWinningNumbersSuccessTest() {
        // given
        String input = "12,5,17,    10, 41, 38";

        // when & then
        Assertions.assertThat(WinningNumbers.from(input))
                .isInstanceOf(WinningNumbers.class);
    }

    @DisplayName("당첨 번호 중 정수가 아닌 문자가 있는 경우 예외가 발생한다")
    @Test
    void nonIntegerExceptionTest() {
        // given
        String input = "12,5,17,i10, 41, 38";

        // when & then
        Assertions.assertThatThrownBy(() -> WinningNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NON_INTEGER_LOTTO.getMessage());
    }

    @DisplayName("당첨 번호 중 로또 번호의 범위가 아닌 정수가 있으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"  ", "", "12,5,17,i10, 41, 38"})
    void numberScopeExceptionTest(String input) {
        // when & then
        Assertions.assertThatThrownBy(() -> WinningNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NON_INTEGER_LOTTO.getMessage());
    }

    @DisplayName("당첨 번호가 6개가 아닌 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "12,7,13,6,9,2,5", "12,,,"})
    void sizeExceptionTest(String input) {
        // when & then
        Assertions.assertThatThrownBy(() -> WinningNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_SIZE_ERROR.getMessage());
    }

    @DisplayName("당첨 번호 중에서 중복이 발생하는 경우 예외가 발생한다")
    @Test
    void duplicateExceptionTest() {
        // given
        String input = "1, 2, 12, 14, 13, 12";

        // when & then
        Assertions.assertThatThrownBy(() -> WinningNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBERS_DUPLICATE.getMessage());
    }

}
