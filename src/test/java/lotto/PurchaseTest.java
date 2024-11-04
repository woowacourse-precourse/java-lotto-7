package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.service.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseTest {

    @DisplayName("금액 입력 받을 시 1000원 단위가 아닐 경우")
    @Test
    void 금액_받을_시에_1000원이하일경우() {
        assertThatThrownBy(() -> new Purchase("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("금액 입력 받을 시 숫자가 아닐 경우")
    @Test
    void 금액_받을_시에_숫자가_아닐_경우() {
        assertThatThrownBy(() -> new Purchase("test"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("정상적으로 금액을 받을 시에")
    @Test
    void 정상적으로_금액을_받을시() {
        //given
        String purchaseAmount = "10000";

        //when
        Purchase purchase = new Purchase(purchaseAmount);
        int getPurchaseAmount = purchase.getPurchaseAccount();

        //then
        assertThat(getPurchaseAmount).isEqualTo(10);

    }
}
