package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

public class BonusNumberInputTest {

    @Test
    @DisplayName("보너스 번호가 1에서 45 범위를 벗어날 때 예외 발생")
    public void testBonusNumberOutOfRange() {
        BonusNumberInput bonusNumberInput = new BonusNumberInput();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusNumberInput.validateBonusNumber("46", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1에서 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 발생")
    public void testBonusNumberDuplicateWithWinningNumbers() {
        BonusNumberInput bonusNumberInput = new BonusNumberInput();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusNumberInput.validateBonusNumber("3", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("정상적인 보너스 번호 입력")
    public void testValidBonusNumber() {
        BonusNumberInput bonusNumberInput = new BonusNumberInput();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = bonusNumberInput.validateBonusNumber("7", winningNumbers);
        assertThat(bonusNumber).isEqualTo(7);
    }
}
