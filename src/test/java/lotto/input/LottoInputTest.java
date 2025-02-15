package lotto.input;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputTest {
    private final LottoInput lottoInput = new LottoInput();

    @Test
    void 올바른_구입_금액을_입력할_때_정상_처리() {
        System.setIn(new java.io.ByteArrayInputStream("5000\n".getBytes()));
        int cost = lottoInput.readCost();
        assertThat(cost).isEqualTo(5000);
    }
    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        System.setIn(new ByteArrayInputStream("invalid\n".getBytes()));
        int cost = lottoInput.readCost();
        assertThat(cost).isEqualTo(0);
    }

    @Test
    void 당첨_번호가_6개_아닐_때_예외_처리() {
        System.setIn(new ByteArrayInputStream("1,2,3,4,5\n".getBytes()));
        List<Integer> winningNumbers = lottoInput.readWinningNumbers();
        assertThat(winningNumbers).isEqualTo(Collections.emptyList());
    }

    @Test
    void 잘못된_형식의_당첨_번호_입력_시_예외_처리() {
        System.setIn(new ByteArrayInputStream("one,two,three\n".getBytes()));
        List<Integer> winningNumbers = lottoInput.readWinningNumbers();
        assertThat(winningNumbers).isEqualTo(Collections.emptyList());
    }

    @Test
    void 잘못된_형식의_보너스_번호_입력_시_예외_처리() {
        System.setIn(new ByteArrayInputStream("invalid\n".getBytes()));
        int bonusNumber = lottoInput.readBonus();
        assertThat(bonusNumber).isEqualTo(0);
    }

}
