package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoUtilityTest {
    @Test
    void 구입금액이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoUtility.validatePurchaseAmount("오천원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_천단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoUtility.validatePurchaseAmount("10500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
