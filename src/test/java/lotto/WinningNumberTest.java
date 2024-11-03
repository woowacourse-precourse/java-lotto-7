package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningNumberTest {
    @DisplayName("당첨 번호가 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void 당첨_번호가_숫자가_아닐_떄_예외가_발생한다() {
        WinningNumber winningNumber = new WinningNumber();
        String input = "1ㅏ";
        assertThrows(IllegalArgumentException.class, () -> {
            winningNumber.parseWinningNumbers(input);
        });
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 당첨_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        WinningNumber winningNumber = new WinningNumber();
        String input = "1,2,3,4,5,6,7";
        assertThrows(IllegalArgumentException.class, () -> {
            winningNumber.parseWinningNumbers(input);
        });
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        WinningNumber winningNumber = new WinningNumber();
        String input = "1,2,3,3,4,5";
        assertThrows(IllegalArgumentException.class, () -> {
            winningNumber.parseWinningNumbers(input);
        });
    }

    @DisplayName("당첨 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 당첨_번호가_범위를_벗어나면_예외가_발생한다() {
        WinningNumber winningNumber = new WinningNumber();
        String input = "1,2,3,3,4,46";
        assertThrows(IllegalArgumentException.class, () -> {
            winningNumber.parseWinningNumbers(input);
        });
    }

    @DisplayName("보너스 번호가 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void 보너스_번호가_숫자가_아닐_떄_예외가_발생한다() {
        WinningNumber winningNumber = new WinningNumber();
        String input = "아";
        assertThrows(IllegalArgumentException.class, () -> {
            winningNumber.parseBonusNumber(input);
        });
    }

    @DisplayName("보너스 번호가 1개를 넘어가면 예외가 발생한다.")
    @Test
    void 보너스_번호가_1개를_넘어가면_예외가_발생한다() {
        WinningNumber winningNumber = new WinningNumber();
        String input = "1,6";
        assertThrows(IllegalArgumentException.class, () -> {
            winningNumber.parseBonusNumber(input);
        });
    }

    @DisplayName("보너스 번호에 당첨 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 보너스_번호에_당첨_번호와_중복된_숫자가_있으면_예외가_발생한다() {
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.parseWinningNumbers("1,2,3,4,5,6");
        int duplicateBonusNumber = 3;
        assertThatThrownBy(() -> {
            winningNumber.validateBonusNumberDuplication(duplicateBonusNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        WinningNumber winningNumber = new WinningNumber();
        String input = "66";
        assertThrows(IllegalArgumentException.class, () -> {
            winningNumber.parseBonusNumber(input);
        });
    }
}