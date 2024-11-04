package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoCreateTest {
    @Test
    void 구입금액이_천단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoCreate("14500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_금액에_맞춰_로또를_발행한다() {
        assertThat(new LottoCreate("5000").getLottoCreateInfo())
                .contains("5");
    }
}
