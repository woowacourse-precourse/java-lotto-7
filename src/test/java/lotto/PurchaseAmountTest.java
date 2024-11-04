package lotto;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {
    @Test
    void 입력한_금액이_빈칸이면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 입력한_금액이_문자_입력이면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 입력한_금액이_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 입력한_금액의_단위가_1000이_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("300"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
