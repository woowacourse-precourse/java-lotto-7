package lotto.vo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", ",", "Ahn"})
    void 문자가_입력되면_예외가_발생한다(final String num) {
        //given
        final String expectedMessage = ErrorMessage.INVALID_PURCHASE_AMOUNT_CHARACTER_ERROR;

        //when & then
        assertThatThrownBy(() -> new PurchaseAmount(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @Test
    void 구입_금액이_양수가_아니면_예외가_발생한다() {
        //given
        final String expectedMessage = ErrorMessage.INVALID_PURCHASE_AMOUNT_ERROR;
        final String purchaseAmount = "-14000";

        //when & then
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @Test
    void 구입_금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다() {
        //given
        final String expectedMessage = ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT_ERROR;
        final String purchaseAmount = "14001";

        //when & then
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }


    @Test
    void 구입_금액이_1000원으로_나누어_떨어지면_객체가_만들어진다() {
        //given
        final String purchaseAmount = "14000";

        //when & then
        assertDoesNotThrow(() -> new PurchaseAmount(purchaseAmount));
    }
}