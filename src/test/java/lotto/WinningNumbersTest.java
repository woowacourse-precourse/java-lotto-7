package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;

class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호의 개수가 6개가 아닐 경우 예외가 발생한다.")
    void testInvalidWinningNumbersLength() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개의 숫자로 이루어져야합니다.");
    }

    @Test
    @DisplayName("당첨 번호에 중복이 있을 경우 예외가 발생한다.")
    void testDuplicateWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 중복되지 않는 숫자로 이루어져야합니다.");
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복될 경우 예외가 발생한다.")
    void testBonusNumberDuplicateWithWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호와 보너스 번호는 중복되지 않는 숫자로 이루어져야합니다.");
    }
}
