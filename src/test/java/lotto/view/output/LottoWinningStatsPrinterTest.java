package lotto.view.output;

import lotto.model.LottoRank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoWinningStatsPrinterTest {

    @Test
    @DisplayName("당첨 통계 출력 테스트")
    void testOutput() {
        LottoWinningStatsPrinter printer = new LottoWinningStatsPrinter();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        HashMap<String, String> winningResults = new HashMap<>();
        winningResults.put("MATCH_THREE", "1");
        winningResults.put("MATCH_FOUR", "0");
        winningResults.put("MATCH_FIVE", "1");
        winningResults.put("MATCH_FIVE_BONUS", "0");
        winningResults.put("MATCH_SIX", "0");
        winningResults.put("TOTAL_RETURN_RATE", "75.0");

        printer.output(winningResults);

        String expectedOutput = "당첨 통계" + System.lineSeparator() +
            "---" + System.lineSeparator() +
            "3개 일치 (5,000원) - 1개" + System.lineSeparator() +
            "4개 일치 (50,000원) - 0개" + System.lineSeparator() +
            "5개 일치 (1,500,000원) - 1개" + System.lineSeparator() +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개" + System.lineSeparator() +
            "6개 일치 (2,000,000,000원) - 0개" + System.lineSeparator() +
            "총 수익률은 75.0%입니다." + System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString());

        System.setOut(System.out); // 원래의 System.out으로 복원
    }
}