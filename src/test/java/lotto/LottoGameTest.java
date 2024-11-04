package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {
    @Test
    void 로또_구입_금액에_입력된_값이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoGame("string"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_금액은_1000_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoGame("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}