package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.model.Budget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottiesFactoryTest {
    private static final long LOTTO_PRICE = 1000;

    @DisplayName("'입력받은 금액 / LOTTO_PRICE' 갯수 만큼의 로또를 구매한다.")
    @Test
    void PURCHASE_LOTTOS() {
        Budget budget = Budget.of(3000L);
        Lotties lotties = LottiesFactory.purchaseLotties(budget);
        assertEquals(3, lotties.size());
    }
}
