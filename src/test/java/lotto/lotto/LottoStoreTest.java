package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoStoreTest {
    LottoStore lottoStore = new LottoStore();

    @Test
    void 사용자_입력한_금액이_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoStore.calculateNumberOfPurchases(7777))
                .isInstanceOf(IllegalArgumentException.class);
    }
}