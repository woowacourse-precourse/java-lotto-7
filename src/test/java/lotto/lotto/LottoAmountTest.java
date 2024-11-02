package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoAmountTest {

    @Test
    void 로또_금액이_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoAmount(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 금액은 음수가 될 수 없습니다.");
    }
}
