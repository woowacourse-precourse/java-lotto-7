package lotto.domain.vo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @Test
    @DisplayName("구입 금액을 입력받아 생성할 수 있다.")
    void purchaseAmountShouldGeneratedByInput() {
        PurchaseAmount purchaseAmount = PurchaseAmount.from("1000");

        assertThat(purchaseAmount)
            .isEqualTo(new PurchaseAmount("1000"));
        assertThat(purchaseAmount.amount())
            .isEqualTo(1000);
    }

    @Test
    @DisplayName("구입 금액으로 구매 가능한 로또 수량을 계산할 수 있다.")
    void purchaseAmountShouldCalculateLottoAmount() {
        PurchaseAmount purchaseAmount = PurchaseAmount.from("10000");

        assertThat(purchaseAmount.calculateRemainder())
            .isEqualTo(10);
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    void purchaseAmountShouldThrowExceptionForIncorrectUnit() {

        assertThatThrownBy(() -> PurchaseAmount.from("0"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
