package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.common.ErrorMessages;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void 올바른_입력값으로_당첨번호가_생성된다() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        assertThat(winningNumbers.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 입력값이_null일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NULL_WINNING_NUMBER);
    }

    @Test
    void 입력값에_숫자_개수가_맞지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBER_COUNT);

        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBER_COUNT);
    }

    @Test
    void 입력값에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.DUPLICATE_WINNING_NUMBER);
    }

    @Test
    void 입력값에_범위를_벗어난_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_NUMBER_RANGE);

        assertThatThrownBy(() -> new WinningNumbers("0,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_NUMBER_RANGE);
    }

    @Test
    void 당첨번호와_로또번호_및_보너스번호에_따라_등급이_올바르게_계산된다() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getWinningNumbers());
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoRank rank = winningNumbers.calculateRank(lotto, bonusNumber);

        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }
}
