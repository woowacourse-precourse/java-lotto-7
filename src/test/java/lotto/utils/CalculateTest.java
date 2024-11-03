package lotto.utils;

import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;
import lotto.domain.PurchasedPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateTest {

    private LottoRanks lottoRanks;
    private PurchasedPrice purchasedPrice;

    @BeforeEach
    void setUp() {
        lottoRanks = new LottoRanks(List.of(
                new LottoRank("5등", 5_000, 3, false, 5),
                new LottoRank("4등", 50_000, 4, false, 3),
                new LottoRank("3등", 1_500_000, 5, false, 2),
                new LottoRank("2등", 30_000_000, 5, true, 0),
                new LottoRank("1등", 2_000_000_000, 6, false, 1) // 1등에 1회 당첨// 2등에 당첨 없음// 3등에 2회 당첨// 4등에 3회 당첨// 5등에 5회 당첨
        ));
        purchasedPrice = new PurchasedPrice(10_000); // 예를 들어, 10,000원 구입
    }

    @Test
    void testTotalPrize() {
        long expectedTotalPrize = 2_000_000_000 + (1_500_000 * 2) + (50_000 * 3) + (5_000 * 5);
        long actualTotalPrize = Calculate.totalPrize(lottoRanks);

        assertEquals(expectedTotalPrize, actualTotalPrize, "상금 총합 계산기가 잘못되었습니다");
    }

    @Test
    void testProfitRate() {
        long totalPrize = Calculate.totalPrize(lottoRanks);
        double expectedProfitRate = (double) totalPrize / purchasedPrice.getPurchasedPrice() * 100;
        double actualProfitRate = Calculate.profitRate(lottoRanks, purchasedPrice);

        assertEquals(expectedProfitRate, actualProfitRate, 0.01, "수익률 계산기가 잘못되었습니다.");
    }
}