package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinRecord;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoServiceControllerTest {
    @BeforeEach
    void setupTestEnvironment() {
        System.setProperty("IS_TEST_ENV", "true");
    }

    @AfterEach
    void resetTestEnvironment() {
        System.clearProperty("IS_TEST_ENV");
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    private ByteArrayOutputStream setByteArrayOutputStream() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }

    private void setLottoServiceController(int purchaseAmount, List<Integer> winningNumbers, int bonusNumber, List<Integer> winRecord) {
        PurchaseAmount.resetInstance();
        WinningLotto.resetInstance();
        WinRecord.resetInstance();
        PurchaseAmount.getPurchaseAmount(purchaseAmount);
        WinningLotto.getWinningLotto(winningNumbers, bonusNumber);
        WinRecord.getWinRecord(winRecord);
    }

    @DisplayName("당첨 통계 출력 확인")
    @Test
    void checkDisplayWinRecord() {
        ByteArrayOutputStream outputStream = setByteArrayOutputStream();
        setLottoServiceController(1000, Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(5));
        LottoServiceController lottoServiceController = new LottoServiceController();
        lottoServiceController.displayWinRecord();

        assertEquals("\n당첨 통계\n" +
                        "---\n" +
                        "3개 일치 (5,000원) - 1개\n" +
                        "4개 일치 (50,000원) - 0개\n" +
                        "5개 일치 (1,500,000원) - 0개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                        "6개 일치 (2,000,000,000원) - 0개\n",
                outputStream.toString());
    }

    @ParameterizedTest
    @DisplayName("사용자 총 수익률 출력 확인")
    @ValueSource(ints = {1000, 5000, 10000, 100000})
    void testDisplayUserLottos(int test) {
        ByteArrayOutputStream outputStream = setByteArrayOutputStream();
        setLottoServiceController(test, Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(0, 0, 0, 0, 0, 5));
        LottoServiceController lottoServiceController = new LottoServiceController();

        BigDecimal totalPurchaseAmount = new BigDecimal(test);
        BigDecimal totalWinningPrize = new BigDecimal(WinRecord.WINNING_PRIZES.get(5));
        BigDecimal successYield = totalWinningPrize.divide(totalPurchaseAmount, 3, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
        String successOutput = String.format("총 수익률은 %.1f%%입니다.\n", successYield.doubleValue());
        lottoServiceController.displayTotalYield();

        assertEquals(successOutput, outputStream.toString());
    }
}
