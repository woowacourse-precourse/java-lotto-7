package lotto.input;

import static lotto.constants.ErrorMessage.INPUT_MUST_BE_NUMBER;
import static lotto.constants.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PurchaseTest {

    @Test
    void 정상_입력_테스트() {
        //given
        Purchase purchase = new Purchase(3000);

        //when, then
        assertThat(3000).isEqualTo(purchase.getPurchase());
    }

    @Test
    void 구매금액이_1000으로_나눠지지_않는_예외_테스트() {
        //given, when, then
        assertThatThrownBy(() -> new Purchase(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_UNIT_ERROR.getMessage());
    }

    @Test
    void 구매금액_음수_예외_테스트() {
        //given, when, then
        assertThatThrownBy(() -> new Purchase(-10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MUST_BE_NUMBER.getMessage());
    }
}