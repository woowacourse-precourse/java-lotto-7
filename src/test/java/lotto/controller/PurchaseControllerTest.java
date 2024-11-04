package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseControllerTest {
    PurchaseController purchaseController=new PurchaseController(new LottoFactory());

    @Test
    @DisplayName("구매 테스트")
    void purchaseVerify() {
        // given
        int amount = 1000;
        Lottos lottos = purchaseController.purchaseLotto(amount);

        // when & then
        assertThat(lottos).isNotNull();
        assertThat(lottos.getCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("천원 단위가 아닌경우")
    void amountMustBeMultiplyOfThousand() {
        // given
        int amount = 1500;
        // when & then
        assertThatThrownBy(()->purchaseController.purchaseLotto(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("천원단위의 금액만 투입 가능합니다.");
    }

    @Test
    @DisplayName("양수가 아닌 경우")
    void amountMustBePositiveNumber() {
        // given
        int amount = -1000;
        // when & then
        assertThatThrownBy(()->purchaseController.purchaseLotto(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 0보다 커야합니다.");
    }
}
