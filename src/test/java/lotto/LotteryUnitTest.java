package lotto;

import lotto.common.error.BonusNumErrorMessage;
import lotto.domain.Lottery;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryUnitTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호_중복_예외() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        int invalidBonusNumber = 6;

        // when & then
        assertThatThrownBy(() -> new Lottery(winningLotto, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BonusNumErrorMessage.CONFLICT_BONUS_NUMBER.getInfoMessage());
    }

    @DisplayName("보너스 번호가 1에서 45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 보너스_번호_범위_예외() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        int invalidBonusNumber = 50;

        // when & then
        assertThatThrownBy(() -> new Lottery(winningLotto, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BonusNumErrorMessage.INVALID_BONUS_NUMBER.getInfoMessage());
    }

    @DisplayName("유효한 당첨 번호와 보너스 번호로 Lottery 객체가 생성된다.")
    @Test
    void 유효한_당첨번호와_보너스번호_객체_생성() {
        // given
        List<Integer> validWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto validWinningLotto = new Lotto(validWinningNumbers);
        int validBonusNumber = 7;

        // when
        Lottery lottery = new Lottery(validWinningLotto, validBonusNumber);

        // then
        assertThat(lottery.getWinningLotto().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(lottery.getBonusNumber()).isEqualTo(validBonusNumber);
    }
}
