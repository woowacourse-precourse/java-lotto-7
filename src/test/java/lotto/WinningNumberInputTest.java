package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningNumberInputTest {

    private WinningNumberInput winningNumberInput;

    @BeforeEach
    void setUp() {
        winningNumberInput = new WinningNumberInput();
    }

    @Test
    void 중복된_당첨_번호_입력시_예외를_던진다() {
        assertThatThrownBy(() -> winningNumberInput.parseWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("번호는 1에서 45 사이의 중복되지 않는 숫자 6개여야 합니다.");
    }

    @Test
    void 당첨번호_설정_테스트() {
        WinningNumberInput winningNumberInput = new WinningNumberInput();
        winningNumberInput.setWinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winningNumberInput.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}