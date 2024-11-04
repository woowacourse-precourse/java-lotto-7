package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Domain.WinningNumbers;
import lotto.Messages.ErrorMessage;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void 당첨_번호가_빈_문자열이면_예외가_발생한다() {
        WinningNumbers winningNumbers = WinningNumbers.create();

        assertThatThrownBy(() -> winningNumbers.registerMainNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_MAIN_NUMBERS.getMessage());
    }

    @Test
    void 당첨_번호에_숫자와_구분자_이외의_문자가_있으면_예외가_발생한다() {
        WinningNumbers winningNumbers = WinningNumbers.create();

        assertThatThrownBy(() -> winningNumbers.registerMainNumbers("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 숫자와 구분자 , 만 입력할 수 있습니다.");
    }

    @Test
    void 당첨_번호의_형식이_잘못되면_예외가_발생한다() {
        WinningNumbers winningNumbers = WinningNumbers.create();

        assertThatThrownBy(() -> winningNumbers.registerMainNumbers("1,2,3,4,5,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.FORMAT_MAIN_NUMBERS.getMessage());
    }

    @Test
    void 당첨_번호에_중복된_번호가_있으면_예외가_발생한다() {
        WinningNumbers winningNumbers = WinningNumbers.create();

        assertThatThrownBy(() -> winningNumbers.registerMainNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호 중 중복된 번호가 있습니다");
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        WinningNumbers winningNumbers = WinningNumbers.create();
        winningNumbers.registerMainNumbers("1,2,3,4,5,6");

        assertThatThrownBy(() -> winningNumbers.registerBonus("6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호 중 중복된 번호가 있습니다");
    }

    @Test
    void 유효한_당첨_번호와_보너스_번호를_등록할_수_있다() {
        WinningNumbers winningNumbers = WinningNumbers.create();
        winningNumbers.registerMainNumbers("1,2,3,4,5,6");
        winningNumbers.registerBonus("7");

        assertThat(winningNumbers.getMainNumbers().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningNumbers.getBonusNumber()).isEqualTo(7);
    }
}
