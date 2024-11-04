package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class WinningNumbersInputTest {

    @Test
    @DisplayName("당첨 번호 입력이 6개가 아닐 때 예외 발생")
    public void testInvalidNumberCount() {
        WinningNumbersInput winningNumbersInput = new WinningNumbersInput();
        assertThatThrownBy(() -> winningNumbersInput.parseAndValidate("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호가 1에서 45 범위를 벗어날 때 예외 발생")
    public void testNumberOutOfRange() {
        WinningNumbersInput winningNumbersInput = new WinningNumbersInput();
        assertThatThrownBy(() -> winningNumbersInput.parseAndValidate("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 각 번호는 1에서 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("정상적인 당첨 번호 입력")
    public void testValidWinningNumbers() {
        WinningNumbersInput winningNumbersInput = new WinningNumbersInput();
        List<Integer> winningNumbers = winningNumbersInput.parseAndValidate("1,2,3,4,5,6");
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
