package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPriceTest {

    @Test
    void 가격이_음수면_예외_발생() {
        assertThatThrownBy(() -> LottoPrice.valueOf(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 가격이_1000미만이면_예외_발생() {
        assertThatThrownBy(() -> LottoPrice.valueOf(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 가격이_1000으로_나누어_떨어지지_않으면_예외_발생() {
        assertThatThrownBy(() -> LottoPrice.valueOf(2300))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 총_가격으로부터_로또의_개수를_구할수_있다() {
        assertThat(LottoPrice.valueOf(2000).getTotalLottoCount()).isEqualTo(2);
    }

}