package lotto.test;

import static lotto.constant.ErrorMessage.LESS_THAN_THOUSAND_PURCHASE_AMOUNT;
import static lotto.constant.ErrorMessage.NOT_PURCHASE_AMOUNT_FORMAT;

import lotto.PurchaseAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Lotto 구매금액을 담은 PurchaseAmount에서")
public class PurchaseAmountTest {
    @Test
    @DisplayName("1000단위의 구매금액이면 오류가 발생하지 않는다")
    public void normalPurchasePrice() {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy(() -> new PurchaseAmount(2000));
    }

    @Test
    @DisplayName("1000보다 작은 구매금액이면 오류가 발생한다")
    public void lessThan1000PurchasePrice() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(100)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LESS_THAN_THOUSAND_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("1000단위의 구매금액이 아니면 오류가 발생한다")
    public void notMultipleOf1000PurchasePrice() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(2100)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_PURCHASE_AMOUNT_FORMAT.getMessage());
    }


    @Test
    @DisplayName("구매금액에 따른 Lotto의 갯수를 계산한다")
    public void getPurchasePrice() {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000);
        //when
        int lottoCount = purchaseAmount.getPurchaseAmount();
        //then
        Assertions.assertThat(lottoCount).isEqualTo(2);
    }
}
