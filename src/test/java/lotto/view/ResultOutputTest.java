package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultOutputTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    private ByteArrayOutputStream setByteArrayOutputStream() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }


    @DisplayName("구입 횟수 출력 확인")
    @Test
    void checkPurchaseCountOutput() {
        ByteArrayOutputStream outputStream = setByteArrayOutputStream();
        ResultOutput resultOutput = new ResultOutput();
        resultOutput.displayPurchaseCount(8);

        assertEquals("\n8개를 구매했습니다.\n", outputStream.toString());
    }

    @DisplayName("구입 로또 출력 확인")
    @Test
    void checkUserLottoOutput() {
        ByteArrayOutputStream outputStream = setByteArrayOutputStream();
        ResultOutput resultOutput = new ResultOutput();
        resultOutput.displayUserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertEquals("[1, 2, 3, 4, 5, 6]\n", outputStream.toString());
    }

    @DisplayName("당첨 통계 출력 확인")
    @Test
    void checkWinRecordOutput() {
        ByteArrayOutputStream outputStream = setByteArrayOutputStream();
        ResultOutput resultOutput = new ResultOutput();
        resultOutput.displayWinRecord(Arrays.asList(0, 0, 0, 0, 0, 1));

        assertEquals("\n당첨 통계\n" +
                        "---\n" +
                        "3개 일치 (5,000원) - 1개\n" +
                        "4개 일치 (50,000원) - 0개\n" +
                        "5개 일치 (1,500,000원) - 0개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                        "6개 일치 (2,000,000,000원) - 0개\n",
                outputStream.toString());
    }

    @DisplayName("총 수익률 출력 확인")
    @Test
    void checkYieldOutput() {
        ByteArrayOutputStream outputStream = setByteArrayOutputStream();
        ResultOutput resultOutput = new ResultOutput();
        resultOutput.displayTotalYield(62.5);

        assertEquals("총 수익률은 62.5%입니다.\n", outputStream.toString());
    }
}
