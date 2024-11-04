package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.exception.ExceptionMessages;
import org.junit.jupiter.api.Test;

public class WinningInfoTest {

    @Test
    void 입력한_보너스_번호가_당첨_번호에_이미_존재하는_경우_예외가_발생한다() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(3);

        assertThatThrownBy(() -> new WinningInfo(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.NUMBER_ALREADY_EXIST.getMessage());
    }

    @Test
    void 입력한_보너스_번호가_당첨_번호에_존재하지_않는_경우_예외가_발생하지_않는다() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(10);

        assertThatCode(() -> new WinningInfo(winningNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }

    @Test
    void 매개변수로_받은_번호가_당첨_번호에_존재할_경우_1을_반환한다() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(10);
        WinningInfo winningInfo = new WinningInfo(winningNumbers, bonusNumber);
        assertThat(winningInfo.isWinningNumbersContainThisNumber(3)).isEqualTo(1);
    }

    @Test
    void 매개변수로_받은_번호가_당첨_번호에_존재하지_않을_경우_0을_반환한다() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(10);
        WinningInfo winningInfo = new WinningInfo(winningNumbers, bonusNumber);
        assertThat(winningInfo.isWinningNumbersContainThisNumber(10)).isEqualTo(0);
    }

    @Test
    void 매개변수로_받은_번호가_보너스_번호와_같을_경우_1을_반환한다() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(10);
        WinningInfo winningInfo = new WinningInfo(winningNumbers, bonusNumber);
        assertThat(winningInfo.isBonusNumberSameAsThis(10)).isEqualTo(1);
    }

    @Test
    void 매개변수로_받은_번호가_보너스_번호와_다를_경우_0을_반환한다() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(10);
        WinningInfo winningInfo = new WinningInfo(winningNumbers, bonusNumber);
        assertThat(winningInfo.isBonusNumberSameAsThis(20)).isEqualTo(0);
    }
}
