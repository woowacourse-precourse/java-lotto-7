package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfitCalculatorTest {

    private ProfitCalculator profitCalculator;
    private LottoResult lottoResult;
    private Lottos lottos;

    @BeforeEach
    @DisplayName("ProfitCalculator 초기화")
    void setUp() {
        // given
        lottoResult = new LottoResult();
        lottoResult.updateResult(WinningInfo.FIRST_WINNER);
        lottoResult.updateResult(WinningInfo.THIRD_WINNER);
        lottoResult.updateResult(WinningInfo.THIRD_WINNER);

        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 3, 5, 7, 9, 11)),
                new Lotto(Arrays.asList(2, 4, 6, 8, 10, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24)),
                new Lotto(Arrays.asList(25, 26, 27, 28, 29, 30)),
                new Lotto(Arrays.asList(31, 32, 33, 34, 35, 36)),
                new Lotto(Arrays.asList(37, 38, 39, 40, 41, 42))
        );
        lottos = new Lottos(lottoList);

        profitCalculator = new ProfitCalculator(lottoResult);
    }

    @Test
    @DisplayName("수익률 계산 테스트 - 당첨 결과가 있는 경우")
    void testGetProfitRateWithWinningResults() {
        // given & when
        int totalBenefit = (2_000_000_000) + (1_500_000 * 2);
        double expectedProfitRate = (double) totalBenefit / (lottos.getLottoCount() * 1000) * 100;
        expectedProfitRate = Math.round(expectedProfitRate * 10.0) / 10.0;

        // then
        assertEquals(expectedProfitRate, profitCalculator.getProfitRate(lottos));
    }

    @Test
    @DisplayName("수익률 계산 테스트 - 당첨 결과가 없는 경우")
    void testGetProfitRateWithoutWinningResults() {
        // given
        lottoResult = new LottoResult();
        profitCalculator = new ProfitCalculator(lottoResult);

        // when & then
        assertEquals(0.0, profitCalculator.getProfitRate(lottos));
    }

    @Test
    @DisplayName("총 수익 계산 테스트")
    void testCalculateTotalBenefit() {
        HashMap<WinningInfo, Integer> expectedResult = lottoResult.getResult();
        assertEquals(1, expectedResult.get(WinningInfo.FIRST_WINNER));
        assertEquals(2, expectedResult.get(WinningInfo.THIRD_WINNER));
        assertEquals(0, expectedResult.get(WinningInfo.SECOND_WINNER));
    }
}
