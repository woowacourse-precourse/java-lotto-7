package lotto;

import static lotto.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.ErrorMessage.INVALID_BONUS_NUMBER_RANGE;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    private Lotto winningNumbers = new Lotto(Arrays.asList(1, 12, 23, 34, 43, 45));

    @DisplayName("보너스 번호가 45보다 크면 예외를 발생시킨다")
    @Test
    void 보너스_번호_범위_초과_예외() {
        //give
        int bonusNumber = 47;
        //when,then
        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber)).
                hasMessage(INVALID_BONUS_NUMBER_RANGE);
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외를 발생시킨다")
    @Test
    void 보너스_번호_범위_미만_예외() {
        //give
        int bonusNumber = -1;
        //when,then
        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber)).
                hasMessage(INVALID_BONUS_NUMBER_RANGE);
    }

    @DisplayName("보너스 번호가 당첨번호와 중복되면 예외를 발생시킨다")
    @Test
    void 보너스_번호_중복_예외() {
        //give
        int bonusNumber = 12;
        //when,then
        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber)).
                hasMessage(DUPLICATE_BONUS_NUMBER);
    }
}