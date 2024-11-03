package lotto.domain;

import static lotto.constants.LottoConstant.PROFIT_RATE;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProfitRateTest {
    private PurchasePrice purchasePrice;

    @BeforeEach
    public void setUp() {
        purchasePrice = new PurchasePrice("10000");
    }

    @DisplayName("구매가격에 대해 올바른 수익률을 반환한다.")
    @Test
    public void 구매가격에_대해_올바른_수익률을_반환한다() {
        Rank.FIRST.countPrize();
        Rank.SECOND.countPrize();

        LottoProfitRate profitRate = LottoProfitRate.of(purchasePrice);

        double expectedProfitSum = (2000000000 * Rank.FIRST.getCount() + 30000000 * Rank.SECOND.getCount());
        double expectedProfitRate = expectedProfitSum / purchasePrice.getAmount() * PROFIT_RATE;

        assertEquals(expectedProfitRate, profitRate.getLottoProfitRate(), 0.01);
    }
}