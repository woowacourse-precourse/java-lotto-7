package lotto.service;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;
import java.util.Map;

public class WinningsCalculatorTest {

    private final WinningsCalculator winningsCalculator = new WinningsCalculator();

    @Test
    @DisplayName("등수별 당첨 횟수를 바탕으로 총 당첨 금액을 정확하게 계산해야 한다.")
    void 등수별_당첨_횟수를_바탕으로_총_당첨_금액을_정확하게_계산해야_한다() {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        rankCount.put(Rank.FIRST, 1);
        rankCount.put(Rank.SECOND, 2);
        rankCount.put(Rank.THIRD, 3);
        rankCount.put(Rank.FOURTH, 4);
        rankCount.put(Rank.FIFTH, 5);

        long expectedTotal =
                (1 * 2_000_000_000L) +
                        (2 * 30_000_000L) +
                        (3 * 1_500_000L) +
                        (4 * 50_000L) +
                        (5 * 5_000L);

        long actualTotal = winningsCalculator.calculateTotalWinnings(rankCount);

        assertThat(actualTotal).isEqualTo(expectedTotal);
    }

    @Test
    @DisplayName("총 당첨 금액과 구매 금액을 바탕으로 수익률을 정확하게 계산해야 한다.")
    void 총_당첨_금액과_구매_금액을_바탕으로_수익률을_정확하게_계산해야_한다() {
        long totalWinnings = 2_000_000_000L;
        int purchaseAmount = 8_000;

        double expectedROI = ((double) totalWinnings / purchaseAmount) * 100;
        expectedROI = Math.round(expectedROI * 10.0) / 10.0; // 소수점 첫째 자리까지 반올림

        double actualROI = winningsCalculator.calculateROI(totalWinnings, purchaseAmount);

        assertThat(actualROI).isEqualTo(expectedROI);
    }

    @Test
    @DisplayName("총 당첨 금액이 0일 때 수익률은 0.0%이어야 한다.")
    void 총_당첨_금액이_0일_때_수익률은_0이어야_한다() {
        long totalWinnings = 0L;
        int purchaseAmount = 10_000;

        double expectedROI = 0.0;

        double actualROI = winningsCalculator.calculateROI(totalWinnings, purchaseAmount);

        assertThat(actualROI).isEqualTo(expectedROI);
    }
}
