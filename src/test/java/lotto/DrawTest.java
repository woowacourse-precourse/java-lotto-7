package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DrawTest {

    @DisplayName("추첨 시 6개의 당첨 번호와 1개의 보너스 번호를 갖는다.")
    @Test
    void drawHas6WinningNumbersAndOneBonusNumber() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Draw draw = new Draw(winningNumbers, 7);

        assertThat(draw).extracting("winningNumbers").isEqualTo(winningNumbers);
        assertThat(draw).extracting("bonusNumber").isEqualTo(7);
    }

    @DisplayName("당첨 번호가 null이면 예외를 던진다.")
    @Test
    void drawWinningNumbersCannotBeNull() {
        assertThatThrownBy(() -> new Draw(null, 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 null 일 수 없습니다.");
    }

}
