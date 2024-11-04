package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("보너스 숫자가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너수_숫자가_담청_번호와_중복_되면_예외가_발생한다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);

        //expected
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATE_WITH_WINNING_ERROR_MESSAGE);
    }

    @DisplayName("로또 당첨 번호를 알려준다.")
    @Test
    void 로또_당첨_번호를_알려준다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        //when
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        //then
        assertThat(winningLotto.getWinningLotto()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 보너스 번호를 알려준다.")
    @Test
    void 로또_보너스_번호를_알려준다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        //when
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        //then
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }

}