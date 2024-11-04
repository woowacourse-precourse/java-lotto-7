package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @DisplayName("당첨번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void 당첨번호에_중복이_있으면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> Validator.validateWinningNumbersDuplicate(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스번호가 당첨번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 6;
        assertThatThrownBy(() -> Validator.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨번호의 개수는 6개여야 한다.")
    @Test
    void 당첨번호의_개수는_6개여야_한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> Validator.validateWinningCount(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력한 당첨번호가 범위내에 없으면 예외를 발생한다.")
    @Test
    void 입력한_당첨번호가_범위내에_없으면_예외를_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 60);
        assertThatThrownBy(() -> Validator.validateWinningNumbersRange(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스번호가 범위내에 없으면 예외를 발생한다.")
    @Test
    void 보너스번호가_범위내에_없으면_예외를_발생한다() {
        Integer bonusNumber = 60;
        assertThatThrownBy(() -> Validator.validateRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
