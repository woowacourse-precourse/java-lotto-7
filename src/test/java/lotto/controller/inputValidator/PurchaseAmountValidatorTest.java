package lotto.controller.inputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {
    @Test
    void 구매금액이_공백일_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                PurchaseAmountValidator.validate(" ")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액을 입력해주세요.");
    }

    @Test
    void 구매금액이_숫자가_아닐_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                PurchaseAmountValidator.validate("abc")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 숫자여야 합니다.");
    }

    @Test
    void 구매금액이_유효한_경우_정상적으로_변환되어야_한다() {
        Long result = PurchaseAmountValidator.validate("1000");
        assertEquals(1000L, result);
    }
}