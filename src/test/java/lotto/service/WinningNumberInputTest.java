package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberInputTest {
    @Test
    @DisplayName("유효한 당첨 번호 입력 시 정상 동작")
    void 유효한_당첨_번호_입력_시_정상_동작() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> winningNumbers = WinningNumberInput.getWinningNumbers(input);

        assertThat(winningNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("중복된 번호가 있는 경우 예외 발생")
    void 중복된_번호가_있는_경우_예외_발생() {
        String input = "1, 2, 3, 4, 5, 5";
        assertThatThrownBy(() -> WinningNumberInput.getWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 있습니다");
    }

    @Test
    @DisplayName("범위를 벗어난 번호가 있는 경우 예외 발생")
    void 범위를_벗어난_번호가_있는_경우_예외_발생() {
        String input1 = "0, 2, 3, 4, 5, 6";
        assertThatThrownBy(() -> WinningNumberInput.getWinningNumbers(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45 사이의 숫자여야 합니다");

        String input2 = "1, 2, 3, 4, 5, 46"; // 46이 범위를 벗어남
        assertThatThrownBy(() -> WinningNumberInput.getWinningNumbers(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45 사이의 숫자여야 합니다");
    }

    @Test
    @DisplayName("숫자가 아닌 값이 포함된 경우 예외 발생")
    void 숫자가_아닌_값이_포함된_경우_예외_발생() {
        String input = "1, 2, 3, 4, 5, a";
        assertThatThrownBy(() -> WinningNumberInput.getWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 숫자로 입력해야 합니다");
    }

    @Test
    @DisplayName("6개 미만 또는 초과의 번호가 입력된 경우 예외 발생")
    void 여섯개_미만_또는_초과의_번호가_입력된_경우_예외_발생() {
        String input = "1, 2, 3, 4, 5"; // 5개 입력
        assertThatThrownBy(() -> WinningNumberInput.getWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다");

        String input2 = "1, 2, 3, 4, 5, 6, 7"; // 7개 입력
        assertThatThrownBy(() -> WinningNumberInput.getWinningNumbers(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다");
    }

    @Test
    @DisplayName("유효한 보너스 번호 입력 시 정상 동작")
    void 유효한_보너스_번호_입력시_정상_동작() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String input = "7";
        int bonusNumber = WinningNumberInput.getBonusNumber(input, winningNumbers);

        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외 발생")
    void 보너스_번호가_당첨_번호와_중복될_경우_예외_발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String input = "6";

        assertThatThrownBy(() -> WinningNumberInput.getBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗어난 경우 예외 발생")
    void 보너스_번호가_범위를_벗어난_경우_예외_발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        String input = "0";
        assertThatThrownBy(() -> WinningNumberInput.getBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);

        String input2 = "46";
        assertThatThrownBy(() -> WinningNumberInput.getBonusNumber(input2, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자가 아닌 값이 포함된 경우 예외 발생")
    void 보너스_숫자가_아닌_값이_포함된_경우_예외_발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String input = "a";

        assertThatThrownBy(() -> WinningNumberInput.getBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
