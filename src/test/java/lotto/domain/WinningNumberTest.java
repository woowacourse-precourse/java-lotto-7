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
}
