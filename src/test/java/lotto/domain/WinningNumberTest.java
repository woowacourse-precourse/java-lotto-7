package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class WinningNumberTest {

    @DisplayName("WinningNumber 객체 생성 테스트")
    @Test
    void createWinningNumber() {
        WinningNumber winningNumber = WinningNumber.from("1,2,3,4,5,6");

        Assertions.assertThat(winningNumber.contains(1)).isTrue();
        Assertions.assertThat(winningNumber.contains(2)).isTrue();
        Assertions.assertThat(winningNumber.contains(3)).isTrue();
        Assertions.assertThat(winningNumber.contains(4)).isTrue();
        Assertions.assertThat(winningNumber.contains(5)).isTrue();
        Assertions.assertThat(winningNumber.contains(6)).isTrue();
    }

    @DisplayName("당첨 번호에 숫자가 아닌 값이 입력되었을 떄 예외 발생시킨다.")
    @Test
    void contains() {
        Assertions.assertThatThrownBy(() -> WinningNumber.from("invalid"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호에 1~45 범위 바깥의 숫자가 입력될 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1,1,2,3,4,5", "0,1,2,3,4,5", "1,2,3,4,5,46"})
    void checkWinningNumberInRange(String inputWinningNumber) {
        Assertions.assertThatThrownBy(() -> WinningNumber.from(inputWinningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 1~45 사이의 숫자를 입력해야 합니다.");
    }

    @DisplayName("당첨 번호가 6개가 아닐 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5", "1,2,3", "1,2", "1"})
    void checkWinningNumberCount(String inputWinningNumber) {
        Assertions.assertThatThrownBy(() -> WinningNumber.from(inputWinningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개까지 입력 가능합니다.");
    }
}
