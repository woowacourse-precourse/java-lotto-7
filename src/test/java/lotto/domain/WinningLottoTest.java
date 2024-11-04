package lotto.domain;

import static lotto.constants.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.constants.ErrorMessage.INVALID_BONUS_NUMBER_RANGE;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    private Lotto winningNumbers = new Lotto(Arrays.asList(1, 12, 23, 34, 43, 45));

    @Test
    void 보너스_번호_범위_초과하면_예외가_발생한다() {
        //give
        int bonusNumber = 47;
        //when,then
        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber)).
                hasMessage(INVALID_BONUS_NUMBER_RANGE);
    }

    @Test
    void 보너스_번호_범위_미만이면_예외가_발생한다() {
        //give
        int bonusNumber = -1;
        //when,then
        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber)).
                hasMessage(INVALID_BONUS_NUMBER_RANGE);
    }

    @Test
    void 보너스_번호_중복되면_예외가_발생한다() {
        //give
        int bonusNumber = 12;
        //when,then
        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber)).
                hasMessage(DUPLICATE_BONUS_NUMBER);
    }
}