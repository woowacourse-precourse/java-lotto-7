package lotto.view;

import lotto.model.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("모든 당첨 등수가 0개인 경우")
    public void testPrintResult_AllZeroResults() {
        Map<Rank, Integer> resultCount = Map.of(
                Rank.FIFTH, 0,
                Rank.FOURTH, 0,
                Rank.THIRD, 0,
                Rank.SECOND, 0,
                Rank.FIRST, 0
        );
        int totalPrize = 0;
        int purchaseAmount = 5000;

        lottoResultPrinter.printResult(resultCount, totalPrize, purchaseAmount);
        String expectedOutput = "당첨 통계\n---\n" +
                "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 0.0%입니다.\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("다양한 당첨 결과를 포함하는 경우")
    public void testPrintResult_WithWinningResults() {
        Map<Rank, Integer> resultCount = Map.of(
                Rank.FIFTH, 1,
                Rank.FOURTH, 2,
                Rank.THIRD, 1,
                Rank.SECOND, 0,
                Rank.FIRST, 0
        );
        int totalPrize = (1 * Rank.FIFTH.getPrize()) + (2 * Rank.FOURTH.getPrize()) + (1 * Rank.THIRD.getPrize());
        int purchaseAmount = 10_000;

        lottoResultPrinter.printResult(resultCount, totalPrize, purchaseAmount);
        String expectedOutput = "당첨 통계\n---\n" +
                "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 2개\n" +
                "5개 일치 (1,500,000원) - 1개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 16050.0%입니다.\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("보너스볼 일치하는 2등")
    public void testPrintResult_WithSecondPlace() {
        Map<Rank, Integer> resultCount = Map.of(
                Rank.FIFTH, 0,
                Rank.FOURTH, 0,
                Rank.THIRD, 0,
                Rank.SECOND, 1,
                Rank.FIRST, 0
        );
        int totalPrize = Rank.SECOND.getPrize();
        int purchaseAmount = 10_000;

        lottoResultPrinter.printResult(resultCount, totalPrize, purchaseAmount);
        String expectedOutput = "당첨 통계\n---\n" +
                "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 300000.0%입니다.\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("보너스볼 일치하지 않는 2등")
    public void testPrintResult_WithThirdPlace() {
        Map<Rank, Integer> resultCount = Map.of(
                Rank.FIFTH, 0,
                Rank.FOURTH, 0,
                Rank.THIRD, 1,
                Rank.SECOND, 0,
                Rank.FIRST, 0
        );
        int totalPrize = Rank.THIRD.getPrize();
        int purchaseAmount = 10_000;

        lottoResultPrinter.printResult(resultCount, totalPrize, purchaseAmount);
        String expectedOutput = "당첨 통계\n---\n" +
                "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 1개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 15000.0%입니다.\n";

        assertEquals(expectedOutput, outputStream.toString());
    }
}
