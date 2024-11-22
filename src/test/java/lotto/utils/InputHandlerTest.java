package lotto.utils;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputHandlerTest {

    @DisplayName("승리 번호 입력을 올바른 숫자 리스트로 전환")
    @Test
    void shouldReturnCorrectWinningNumbers() {
        String input = "1, 2, 3, 4, 5, 6";
        Assertions.assertThat(InputHandler.toWinningNumbersValue(input))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("승리 번호 입력에 문자 또는 기호가 포함되면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, a", "1, 2, 4, ?, 6"})
    void throwExceptionIfHasInvalidWinningNumberInput(String input) {
        Assertions.assertThatThrownBy(() -> InputHandler.toWinningNumbersValue(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력을 올바른 숫자로 전환")
    @Test
    void shouldReturnCorrectBonusNumber() {
        String input = "7";

        Assertions.assertThat(InputHandler.toBonusNumberValue(input))
                .isEqualTo(7);
    }

    @DisplayName("보너스 번호 입력이 문자 또는 기호이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"?", "a"})
    void throwExceptionIfHasInvalidBonusNumberInput(String input) {
        Assertions.assertThatThrownBy(() -> InputHandler.toBonusNumberValue(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력을 올바른 숫자로 전환")
    @Test
    void shouldReturnCorrectPrice() {
        String input = "1000";
        Assertions.assertThat(InputHandler.toMoneyValue(input))
                .isEqualTo(1000);
    }

    @DisplayName("금액 입력이 문자 또는 기호이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"g", ","})
    void throwExceptionIfHasInvalidMoneyInput(String input) {
        Assertions.assertThatThrownBy(() -> InputHandler.toMoneyValue(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}