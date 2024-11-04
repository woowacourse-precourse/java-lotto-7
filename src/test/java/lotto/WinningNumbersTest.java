package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("숫자가 아닌 값 입력시")
    @Test
    void 숫자가_아닌값_입력시_예외테스트() {
        String invalidWinningNumbers = "1,2,three,4,5,6";
        String bonusNumber = "7";

        assertThatThrownBy(() -> new WinningNumbers(invalidWinningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자로 변환할 수 없는 값이 입력되었습니다.");
    }

    @DisplayName("보너스에 숫자가 아닌 값 입력시")
    @Test
    void 보너스에_숫자가_아닌값_입력시_예외테스트() {
        String winningNumbers = "1,2,3,4,5,6";
        String invalidBonusNumber = "seven";

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자로 변환할 수 없는 값이 입력되었습니다.");
    }

    @DisplayName("빈 값 입력시")
    @Test
    void 빈값_입력시_예외테스트() {
        String missingWinningNumbers = "";
        String bonusNumber = "7";

        assertThatThrownBy(() -> new WinningNumbers(missingWinningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자로 변환할 수 없는 값이 입력되었습니다.");
    }

    @DisplayName("보너스와 중복되는 경우")
    @Test
    void 중복된_값_입력시_예외테스트() {
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "6";

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("중복된 값 입력시")
    @Test
    void 중복된_값_입력된_경우_예외테스트() {
        String winningNumbers = "1,2,3,4,5,5";
        String bonusNumber = "7";

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호에는 중복된 숫자가 포함될 수 없습니다.");
    }

}