package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


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

    @DisplayName("당첨 번호에 숫자가 아닌 값이 입력되었을 떄 예외 발생")
    @Test
    void contains() {
        Assertions.assertThatThrownBy(() -> WinningNumber.from("invalid"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 숫자여야 합니다.");
    }
}
