package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호의_개수가_6개가_아니면_예외가_발생한다() {
        WinNumber winNumber = new WinNumber();
        assertThatThrownBy(() -> winNumber.inputWinNumber("1,2,3,4,5"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("당첨 번호는 6개여야 합니다.");
    }

    @DisplayName("당첨 번호가 1부터 45의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 당첨_번호가_범위를_벗어나면_예외가_발생한다() {
        WinNumber winNumber = new WinNumber();
        assertThatThrownBy(() -> winNumber.inputWinNumber("1,2,3,4,5,46"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("당첨 번호는 1부터 45 사이여야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        WinNumber winNumber = new WinNumber();
        winNumber.inputWinNumber("1,2,3,4,5,6");
        assertThatThrownBy(() -> winNumber.inputBonusNumber(3))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("보너스 번호는 당첨 번호와 중복되면 안됩니다.");
    }
}
