package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitCalculatorTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("수익률 계산 및 출력 테스트 ")
    void testCalculateAndPrintProfitWithSmallerAmount() {
        // given: 작은 구입 금액과 당첨 개수 설정
        int purchaseAmount = 2000;  // 2장의 로또 구매 (2000원)

        Map<Integer, Integer> resultCounts = new HashMap<>();
        resultCounts.put(6, 1);    // 1등 1개
        resultCounts.put(5, 0);    // 3등 0개 (2등은 별도로 처리)
        resultCounts.put(4, 0);    // 4등 0개
        resultCounts.put(3, 0);    // 5등 0개

        int firstPrizeCount = 1;   // 1등 개수
        int secondPrizeCount = 0;  // 2등 개수

        // when: 수익률 계산 및 출력
        LottoProfitCalculator.calculateAndPrintProfit(purchaseAmount, resultCounts, firstPrizeCount, secondPrizeCount);

        // then: 출력된 결과 검증
        String expectedOutput = "총 수익률은 100000000.0%입니다.\n";
        assertThat(outputStream.toString().trim()).isEqualTo(expectedOutput.trim());
    }

    @Test
    @DisplayName("수익률 계산 및 출력 테스트 - 당첨이 없는 경우")
    void testCalculateAndPrintProfitWithNoWinners() {
        // given: 구입 금액과 당첨 개수가 모두 0인 경우
        int purchaseAmount = 8000;  // 8장의 로또 구매 (8000원)

        Map<Integer, Integer> resultCounts = new HashMap<>();
        resultCounts.put(6, 0);    // 1등 0개
        resultCounts.put(5, 0);    // 3등 0개
        resultCounts.put(4, 0);    // 4등 0개
        resultCounts.put(3, 0);    // 5등 0개

        int firstPrizeCount = 0;   // 1등 개수
        int secondPrizeCount = 0;  // 2등 개수

        // when: 수익률 계산 및 출력
        LottoProfitCalculator.calculateAndPrintProfit(purchaseAmount, resultCounts, firstPrizeCount, secondPrizeCount);

        // then: 출력된 결과 검증
        String expectedOutput = "총 수익률은 0.0%입니다.\n";
        assertThat(outputStream.toString().trim()).isEqualTo(expectedOutput.trim());
    }
}
