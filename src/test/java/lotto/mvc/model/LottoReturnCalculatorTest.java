package lotto.mvc.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.EnumMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("총 수익률 계산하는 기능 테스트")
class LottoReturnCalculatorTest {
    @Test
    @DisplayName("총 수익률 계산 점검_1")
    void test1() {
        long purchaseAmount = 8000;

        EnumMap<LottoWinningAmount, Integer> expectedResults = new EnumMap<>(LottoWinningAmount.class);
        expectedResults.put(LottoWinningAmount.SIX, 1);
        expectedResults.put(LottoWinningAmount.FIVE_PLUS_BONUS, 0);
        expectedResults.put(LottoWinningAmount.FIVE, 0);
        expectedResults.put(LottoWinningAmount.FOUR, 2);
        expectedResults.put(LottoWinningAmount.THREE, 0);

        assertTrue(LottoReturnCalculator.calculateTotalReturn(expectedResults, purchaseAmount)
                .compareTo(new BigDecimal(25_001_250)) == 0);
    }

    @Test
    @DisplayName("총 수익률 계산 점검_2")
    void test2() {
        long purchaseAmount = 20_000;

        EnumMap<LottoWinningAmount, Integer> expectedResults = new EnumMap<>(LottoWinningAmount.class);
        expectedResults.put(LottoWinningAmount.SIX, 1);
        expectedResults.put(LottoWinningAmount.FIVE_PLUS_BONUS, 0);
        expectedResults.put(LottoWinningAmount.FIVE, 0);
        expectedResults.put(LottoWinningAmount.FOUR, 2);
        expectedResults.put(LottoWinningAmount.THREE, 0);

        assertTrue(LottoReturnCalculator.calculateTotalReturn(expectedResults, purchaseAmount)
                .compareTo(new BigDecimal(10_000_500)) == 0);
    }

    @Test
    @DisplayName("총 수익률 계산 점검_3")
    void test3() {
        long purchaseAmount = 20_000;

        EnumMap<LottoWinningAmount, Integer> expectedResults = new EnumMap<>(LottoWinningAmount.class);
        expectedResults.put(LottoWinningAmount.SIX, 0);
        expectedResults.put(LottoWinningAmount.FIVE_PLUS_BONUS, 0);
        expectedResults.put(LottoWinningAmount.FIVE, 0);
        expectedResults.put(LottoWinningAmount.FOUR, 0);
        expectedResults.put(LottoWinningAmount.THREE, 1);

        assertTrue(LottoReturnCalculator.calculateTotalReturn(expectedResults, purchaseAmount)
                .compareTo(new BigDecimal(25)) == 0);
    }

    @Test
    @DisplayName("총 수익률 계산 점검_4")
    void test4() {
        long purchaseAmount = 27_000;

        EnumMap<LottoWinningAmount, Integer> expectedResults = new EnumMap<>(LottoWinningAmount.class);
        expectedResults.put(LottoWinningAmount.SIX, 0);
        expectedResults.put(LottoWinningAmount.FIVE_PLUS_BONUS, 0);
        expectedResults.put(LottoWinningAmount.FIVE, 0);
        expectedResults.put(LottoWinningAmount.FOUR, 0);
        expectedResults.put(LottoWinningAmount.THREE, 1);

        assertTrue(LottoReturnCalculator.calculateTotalReturn(expectedResults, purchaseAmount)
                .compareTo(new BigDecimal(18.5)) == 0);
    }
}