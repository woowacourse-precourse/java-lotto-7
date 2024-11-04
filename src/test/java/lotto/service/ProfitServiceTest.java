package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.model.WinningLotto;
import lotto.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProfitServiceTest {
    private ProfitService profitService;

    @BeforeEach
    public void setUp() {
        profitService = new ProfitService();
        WinningLotto.resetMatchCounts();
    }

    @Test
    public void 당첨_금액이_0일때_테스트() {
        // Given
        int lottoCount = 10;

        // When
        double profitRate = profitService.calculate(lottoCount);

        // Then
        assertEquals(0.0, profitRate);
    }

    @Test
    public void 정상_결과_출력_테스트() {
        // Given
        int lottoCount = 10;

        WinningLotto.FOUR_MATCH.incrementMatchCount();
        WinningLotto.FIVE_MATCH.incrementMatchCount();

        // When
        double profitRate = profitService.calculate(lottoCount);

        int totalPrize = WinningLotto.FOUR_MATCH.getPrize() * WinningLotto.FOUR_MATCH.getMatchCount() +
                WinningLotto.FIVE_MATCH.getPrize() * WinningLotto.FIVE_MATCH.getMatchCount();

        double expectedProfitRate = (double) totalPrize / (lottoCount * Constants.LOTTO_PRICE);

        // Then
        assertEquals(expectedProfitRate, profitRate);
    }
}
