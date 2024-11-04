package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {
    @Test
    void 로또_구입_금액에_입력된_값이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoGame("string"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}