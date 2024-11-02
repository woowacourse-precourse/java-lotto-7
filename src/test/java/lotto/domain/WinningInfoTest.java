package lotto.domain;

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
}
