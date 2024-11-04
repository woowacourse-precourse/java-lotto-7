package lotto.model;

import lotto.constant.ExceptionMessage;
import lotto.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningLottoTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호_중복_예외_테스트() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));

        // when, then
        Assertions.assertThatThrownBy(() -> winningLotto.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_WINNING_AND_BONUS_ERROR);
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 보너스_번호_범위_예외_테스트() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));

        // when, then
        Assertions.assertThatThrownBy(() -> winningLotto.setBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE_NUMBER_ERROR);

        Assertions.assertThatThrownBy(() -> winningLotto.setBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE_NUMBER_ERROR);
    }


    @DisplayName("당첨 번호와 보너스 번호가 모두 정상적으로 설정된다.")
    @Test
    void 당첨_번호와_보너스_번호_정상_설정_테스트() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(winningNumbers);

        // when
        winningLotto.setBonusNumber(7);

        // then
        Assertions.assertThat(winningLotto.getNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
        Assertions.assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }
}