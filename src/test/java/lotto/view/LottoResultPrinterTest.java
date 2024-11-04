package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultPrinterTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private LottoResultPrinter lottoResultPrinter;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        lottoResultPrinter = new LottoResultPrinter();
    }

    @Test
    public void testPrintResult_AllZeroResults() {
        // 모든 당첨 등수가 0개인 경우
        Map<Integer, Integer> resultCount = Map.of(3, 0, 4, 0, 5, 0, 6, 0);
        int totalPrize = 0;
        int purchaseAmount = 5000;

        lottoResultPrinter.printResult(resultCount, totalPrize, purchaseAmount);
        String expectedOutput = "당첨 통계\n---\n" +
                "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 0.00%입니다.\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testPrintResult_ProfitRateCalculation() {
        // 수익률 계산이 포함된 결과 출력 테스트
        Map<Integer, Integer> resultCount = Map.of(3, 1, 4, 0, 5, 0, 6, 0);
        int totalPrize = 5_000;
        int purchaseAmount = 8_000; // 수익률이 62.5%여야 함

        lottoResultPrinter.printResult(resultCount, totalPrize, purchaseAmount);
        String expectedOutput = "당첨 통계\n---\n" +
                "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 62.5%입니다.\n"; // 소수점 첫째 자리까지만 표시

        assertEquals(expectedOutput, outputStream.toString());
    }
}
