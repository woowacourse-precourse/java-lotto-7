package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoCalculatorTest {

    private LottoCalculator calculator;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 7, 8, 9)), // 3개 일치
                new Lotto(List.of(1, 2, 3, 4, 10, 11)), // 4개 일치
                new Lotto(List.of(1, 2, 3, 4, 5, 12)), // 5개 일치 (보너스 없음)
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 5개 일치 + 보너스
                new Lotto(List.of(1, 2, 3, 4, 5, 6))  // 6개 일치
        );
        int purchaseAmount = 5000;
        calculator = new LottoCalculator(winningNumbers, bonusNumber, lottos, purchaseAmount);
    }

    @Test
    @DisplayName("각 등수별 당첨 횟수를 정확히 계산한다.")
    void testCalculateResults() {
        calculator.calculateResults();

        assertEquals(1, calculator.getResultCounts().get("3개 일치 (5,000원)"));
        assertEquals(1, calculator.getResultCounts().get("5개 일치 (1,500,000원)"));
        assertEquals(1, calculator.getResultCounts().get("4개 일치 (50,000원)"));
        assertEquals(1, calculator.getResultCounts().get("5개 일치, 보너스 볼 일치 (30,000,000원)"));
        assertEquals(1, calculator.getResultCounts().get("6개 일치 (2,000,000,000원)"));
    }

    @Test
    @DisplayName("총 수익률을 정확히 계산한다.")
    void testProfitRate() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 7, 8, 9)), // 3개 일치
                new Lotto(List.of(1, 2, 3, 10, 11, 12)), // 3개 일치
                new Lotto(List.of(1, 2, 3, 4, 10, 11))  // 4개 일치
        );
        int purchaseAmount = 5000;

        // 계산기 생성
        LottoCalculator calculator = new LottoCalculator(winningNumbers, bonusNumber, lottos, purchaseAmount);
        calculator.calculateResults();

        // 당첨금과 수익률 계산
        int totalPrize = calculator.calculateTotalPrize(); // 총 상금 = (3개 일치 2개 * 5000) + (4개 일치 1개 * 50000) = 60000원
        double profitRate = ((double) totalPrize / purchaseAmount) * 100;

        // 검증
        assertEquals(60000, totalPrize); // 총 상금 계산
        assertEquals(1200.0, Math.round(profitRate * 10) / 10.0); // 수익률 계산
    }
}
