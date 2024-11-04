package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @DisplayName("PurchaseAmount를 생성할 수 있다.")
    @Test
    void createPurchaseAmount() {
        //given
        int purchaseAmount = 1000;

        //when
        PurchaseAmount createPurchaseAmount = PurchaseAmount.from(purchaseAmount);

        //then
        assertThat(createPurchaseAmount).isEqualTo(PurchaseAmount.from(purchaseAmount));
    }

    @DisplayName("구입 금액이 10만원을 초과하면 예외를 발생한다.")
    @Test
    void exceedAmount() {
        //given
        int purchaseAmount = 100001;

        //when //then
        assertThatThrownBy(() -> PurchaseAmount.from(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EXCEED_PURCHASE_AMOUNT.getErrorMessage());
    }

    @DisplayName("구입 금액이 10만원을 초과하지 않으면 예외를 발생하지 않는다.")
    @Test
    void nonExceedAmount() {
        //given
        int purchaseAmount = 100000;

        //when //then
        assertThatCode(() -> PurchaseAmount.from(purchaseAmount))
                .doesNotThrowAnyException();
    }

    @DisplayName("구입 금액이 1000원 단위가 아니라면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "999", "9999", "1001", "1500"})
    void notAmountUnit(int purchaseAmount) {
        //when //then
        assertThatThrownBy(() -> PurchaseAmount.from(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_DIVIDE_PURCHASE_AMOUNT.getErrorMessage());
    }

    @DisplayName("구매 수량을 계산할 수 있다.")
    @Test
    void amountQuantity() {
        //given
        PurchaseAmount purchaseAmount = PurchaseAmount.from(1000);

        //when
        int quantity = purchaseAmount.calculateQuantity();

        //then
        assertThat(quantity).isEqualTo(1);
    }
}
