package lotto.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ErrorMessages;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어나는 경우 예외가 발생한다.")
    void bonusNumberOutOfRange() {
        String input = "1,2,3,4,5,6";
        WinningNumbers winningNumbers = new WinningNumbers(input);
        int bonusNumber = 0;
        assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외가 발생한다.")
    void bonusNumberDuplicateWithWinningNumbers() {
        String input = "1,2,3,4,5,6";
        WinningNumbers winningNumbers = new WinningNumbers(input);
        int bonusNumber = 6;
        assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.BONUS_NUMBER_DUPLICATE);
    }

    @Test
    @DisplayName("보너스 번호가 정상적으로 생성된다.")
    void createBonusNumberSuccessfully() {
        String input = "1,2,3,4,5,6";
        WinningNumbers winningNumbers = new WinningNumbers(input);
        int bonusNumber = 7;
        BonusNumber bonus = new BonusNumber(bonusNumber, winningNumbers);
        assertThat(bonus.getBonusNumber()).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호가 음수인 경우 예외가 발생한다.")
    void bonusNumberIsNegative() {
        String input = "1,2,3,4,5,6";
        WinningNumbers winningNumbers = new WinningNumbers(input);
        int bonusNumber = -7;
        assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
    }
}
