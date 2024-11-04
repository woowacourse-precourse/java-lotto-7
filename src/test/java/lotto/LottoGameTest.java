package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {
    private final LottoGameValidator validator = new LottoGameValidator();
    private static final int LOTTO_PRICE = 1000;

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateAmount(2500, LOTTO_PRICE))
                .isInstanceOf(IllegalArgumentException.class);
    }
}