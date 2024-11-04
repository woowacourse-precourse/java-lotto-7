package lotto.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.WinningNumbers;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @Test
    void 당첨_번호와_보너스_번호_유효한_입력() {
        String numbersInput = "1,2,3,4,5,6";
        String bonusInput = "7";
        WinningNumbers winningNumbers = new WinningNumbers(numbersInput, bonusInput);

        assertThat(winningNumbers.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningNumbers.getBonusNumber()).isEqualTo(7);
    }

    @Test
    void 당첨_번호_개수가_유효하지_않을_때_예외가_발생한다() {
        String numbersInput = "1,2,3,4,5";
        String bonusInput = "7";

        assertThatThrownBy(() -> new WinningNumbers(numbersInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 당첨_번호에_중복된_숫자가_있을_때_예외가_발생한다() {
        String numbersInput = "1,2,3,3,5,6";
        String bonusInput = "7";

        assertThatThrownBy(() -> new WinningNumbers(numbersInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    void 당첨_번호가_범위를_벗어날_때_예외가_발생한다() {
        String numbersInput = "1,2,3,4,5,46";
        String bonusInput = "7";

        assertThatThrownBy(() -> new WinningNumbers(numbersInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 당첨_번호가_숫자가_아닐_때_예외가_발생한다() {
        String numbersInput = "1,2,3,4,5,a";
        String bonusInput = "7";

        assertThatThrownBy(() -> new WinningNumbers(numbersInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 모두 숫자여야 합니다.");
    }

    @Test
    void 당첨_번호가_빈_문자열일_때_예외가_발생한다() {
        String numbersInput = "";
        String bonusInput = "7";

        assertThatThrownBy(() -> new WinningNumbers(numbersInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 모두 숫자여야 합니다.");
    }

    @Test
    void 보너스번호가_범위를_벗어날_때_예외가_발생한다() {
        String numbersInput = "1,2,3,4,5,6";
        String bonusInput = "46";

        assertThatThrownBy(() -> new WinningNumbers(numbersInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스번호가_당첨번호와_중복될_때_예외가_발생한다() {
        String numbersInput = "1,2,3,4,5,6";
        String bonusInput = "6";

        assertThatThrownBy(() -> new WinningNumbers(numbersInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @Test
    void 보너스번호가_숫자가_아닐_때_예외가_발생한다() {
        String numbersInput = "1,2,3,4,5,6";
        String bonusInput = "a";

        assertThatThrownBy(() -> new WinningNumbers(numbersInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 모두 숫자여야 합니다.");
    }

    @Test
    void 보너스번호가_빈_문자열일_때_예외가_발생한다() {
        String numbersInput = "1,2,3,4,5,6";
        String bonusInput = "";

        assertThatThrownBy(() -> new WinningNumbers(numbersInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 모두 숫자여야 합니다.");
    }
}
