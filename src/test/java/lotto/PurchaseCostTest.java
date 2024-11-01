package lotto;

import org.junit.jupiter.api.BeforeEach;

public class PurchaseCostTest {
    static PurchaseCost purchaseCost;

    @BeforeEach
    void 구입금액_객체_생성() {
        purchaseCost = new PurchaseCost(8000);
    }
}
