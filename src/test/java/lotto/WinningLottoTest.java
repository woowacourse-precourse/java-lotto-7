package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import constants.ErrorMessage;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 당첨_로또_생성() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        assertThat(winningLotto).isEqualTo(new WinningLotto("1,2,3,4,5,6", "7"));
    }

    @Test
    void 입력된_당첨_번호가_6개가_아닌_경우_예외() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6,7", "8"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MATCH_LOTTO_SIZE);
    }
}
