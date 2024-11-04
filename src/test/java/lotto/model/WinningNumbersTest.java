package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static lotto.exception.ExceptionErrorMessage.DUPLICATED_LOTTO_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

public class WinningNumbersTest {

    @Test
    public void 생성자가_제대로_작동되어_당첨번호를_생성한다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        Assertions.assertNotNull(winningNumbers);
        Assertions.assertEquals(winningLotto, winningNumbers.getWinningLottoNumber());
        Assertions.assertEquals(bonusNumber, winningNumbers.getBonusLottoNumber());
    }

    @Test
    public void 중복되는_번호가_있으면_예외를_발생시킨다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;

        assertThatThrownBy(() -> new WinningNumbers(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_LOTTO_NUMBER_MESSAGE.toString());
    }
}