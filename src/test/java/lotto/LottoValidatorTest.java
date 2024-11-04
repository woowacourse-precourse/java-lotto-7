package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoValidatorTest {
    @Test
    void 구입_금액이_1000원_단위가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
