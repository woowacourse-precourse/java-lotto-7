package lotto.purchase.controller;

import lotto.purchase.controller.port.PurchaseService;
import lotto.purchase.domain.Money;
import lotto.purchase.domain.Purchase;
import lotto.purchase.domain.PurchaseResult;
import lotto.purchase.service.MockPurchaseService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseControllerTest {

    private PurchaseService purchaseService;

    @BeforeEach
    void setUp() {
        purchaseService = new MockPurchaseService();
    }

    @Test
    @DisplayName("controller에 MoneyValue를 argument로 호출하면 Purchase를 반환한다.")
    void createPurchaseTest() {
        // given
        long moneyValue = 10000;

        // when
        Purchase purchase = purchaseService.createPurchase(moneyValue);

        // then
        Assertions.assertThat(purchase.getMoney().getQuantitiesCanBuy())
                .isEqualTo(Money.of(moneyValue).getQuantitiesCanBuy());
        Assertions.assertThat(purchase.getLottoResultId()).isNotNull();
        Assertions.assertThat(purchase.getLottoResultId()).isInstanceOf(String.class);
        Assertions.assertThat(purchase.getId()).isNotNull();
        Assertions.assertThat(purchase.getId()).isInstanceOf(String.class);
    }

    @Test
    @DisplayName("controller에 purchaseId를 호출하면 PurcahseResult를 반환한다.")
    void getPurchaseResultTest() {
        // given
        String purchaseId = "purchaseId";

        // when
        PurchaseResult purchaseResult = purchaseService.getPurchaseResult(purchaseId);

        // then
        Assertions.assertThat(purchaseResult).isInstanceOf(PurchaseResult.class);
    }
}