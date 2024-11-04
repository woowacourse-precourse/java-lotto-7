package lotto.input;

import org.junit.jupiter.api.Test;

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
        System.setIn(new java.io.ByteArrayInputStream("invalid\n".getBytes()));
        assertThatThrownBy(() -> lottoInput.readCost())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
    }


    @Test
    void 당첨_번호가_6개_아닐_때_예외_처리() {
        System.setIn(new java.io.ByteArrayInputStream("1,2,3,4,5\n".getBytes()));
        assertThatThrownBy(() -> lottoInput.readWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    void 잘못된_형식의_당첨_번호_입력_시_예외_처리() {
        System.setIn(new java.io.ByteArrayInputStream("one,two,three\n".getBytes()));
        assertThatThrownBy(() -> lottoInput.readWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 숫자로 입력해야 합니다.");
    }

    @Test
    void 잘못된_형식의_보너스_번호_입력_시_예외_처리() {
        System.setIn(new java.io.ByteArrayInputStream("invalid\n".getBytes()));
        assertThatThrownBy(() -> lottoInput.readBonus())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
    }

}
