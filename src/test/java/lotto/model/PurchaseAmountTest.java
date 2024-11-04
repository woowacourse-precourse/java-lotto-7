package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @Test
    @DisplayName("올바른 구매 금액으로 객체가 정상적으로 생성된다")
    void createPurchaseAmount() {
        // given, when
        PurchaseAmount purchaseAmount = new PurchaseAmount("2000");

        // then
        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(2000);
        assertThat(purchaseAmount.getLottoQuantity()).isEqualTo(2);
    }

    @Test
    @DisplayName("구매 금액이 음수이면 예외가 발생한다")
    void validateNegativeAmount() {
        assertThatThrownBy(() -> new PurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 0 이상이어야 합니다.");
    }

    @Test
    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다")
    void validateAmountUnit() {
        assertThatThrownBy(() -> new PurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
    }
}
