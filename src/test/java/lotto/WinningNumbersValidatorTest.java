package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersValidatorTest {

    @DisplayName("당첨 번호가 1~45 범위를 벗어나면 예외가 발생한다")
    @Test
    void 당첨_번호_범위_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 46), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호와 보너스 번호는 1~45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호가 중복되면 예외가 발생한다")
    @Test
    void 당첨_번호_중복_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 중복될 수 없습니다.");
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다")
    @Test
    void 당첨_번호_개수_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개여야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void 보너스_번호_중복_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다")
    @Test
    void 보너스_번호_범위_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호와 보너스 번호는 1~45 사이의 숫자여야 합니다.");
    }
}
