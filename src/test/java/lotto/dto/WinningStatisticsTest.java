package lotto.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.model.LottoPurchaseAmount;
import lotto.model.WinningResult;
import lotto.rank.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    private LottoPurchaseAmount lottoPurchaseAmount;
    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        lottoPurchaseAmount = new LottoPurchaseAmount(8_000L);

        winningResult = new WinningResult();
        winningResult.addRankCount(Ranking.FIFTH);
    }

    @Test
    void 통계_메시지_정상_출력_테스트() {
        // Given
        WinningStatistics winningStatistics = new WinningStatistics(lottoPurchaseAmount, winningResult);

        String expectedMessage = String.join("\n",
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                String.format("총 수익률은 %s%%입니다.", "62.5")
        );

        // When
        String actualMessage = winningStatistics.getWinningStatisticsMessage();

        // Then
        assertEquals(expectedMessage, actualMessage.trim());
    }
}