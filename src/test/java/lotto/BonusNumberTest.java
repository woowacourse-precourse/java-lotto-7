package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @DisplayName("보너스 번호는 1부터 45 사이의 숫자여야 한다.")
    @Test
    void 보너스_번호가_1부터_45_사이가_아니면_예외가_발생한다() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> new BonusNumber(0, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호는 당첨 번호와 중복되지 않아야 한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> new BonusNumber(6, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }
}
