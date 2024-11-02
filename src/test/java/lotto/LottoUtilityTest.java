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

    @Test
    void 입력한_당첨번호가_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoUtility.stringToWinningNumbers("이,삼,사,오,육"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
