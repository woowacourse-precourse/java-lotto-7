package lotto.domain;

import lotto.constant.LottoConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @Test
    @DisplayName("PurchaseAmount 객체를 생성한다.")
    void createPurchaseAmount() {
        // given
        int amount = 1000;
        // when
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        // then
        assertThat(purchaseAmount).isNotNull();
    }

    @Test
    @DisplayName("1000원 이하가 입력될 경우 예외가 발생한다.")
    void validateMinAmount() {
        // given
        int amount = 999;
        // when, then
        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 금액 / 로또 1개당 금액을 계산하여 반환한다.")
    void getLottoCount() {
        // given
        int amount = 10000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        // when
        int count = purchaseAmount.getLottoCount();
        // then
        assertThat(count).isEqualTo(amount / LottoConstant.LOTTO_PRICE.getValue());
    }
}