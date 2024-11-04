package lotto;

import lotto.machine.PrizeStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private LottoResult lottoResult;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("incrementPrizeCount 메서드가 호출되면 해당 PrizeStatus의 카운트가 증가하여 printResult에 반영된다.")
    void incrementPrizeCountAndPrintResultTest() {
        // THREE_MATCH는 2번, FIVE_MATCH는 1번 증가
        lottoResult.incrementPrizeCount(PrizeStatus.THREE_MATCH);
        lottoResult.incrementPrizeCount(PrizeStatus.THREE_MATCH);
        lottoResult.incrementPrizeCount(PrizeStatus.FIVE_MATCH);

        // 출력 테스트
        long purchaseValue = 100000;
        lottoResult.printResult(purchaseValue);

        String output = outputStream.toString().trim();

        // 예상 출력값이 포함되어 있는지 확인
        assertThat(output).contains("당첨 통계");
        assertThat(output).contains("3개 일치 (5,000원) - 2개");
        assertThat(output).contains("5개 일치 (1,500,000원) - 1개");

        double expectedProfitRatio = ((5000 * 2 + 1500000) / (double) purchaseValue) * 100;
        assertThat(output).contains(String.format("총 수익률은 %.1f%%입니다.", expectedProfitRatio));
    }

    @Test
    @DisplayName("printResult 메서드가 모든 PrizeStatus의 기본 카운트 0을 포함한 출력을 한다.")
    void printResultDefaultCountsTest() {
        long purchaseValue = 5000;
        lottoResult.printResult(purchaseValue);

        String output = outputStream.toString().trim();

        // 각 PrizeStatus가 기본 카운트 0으로 출력되는지 확인
        for (PrizeStatus status : PrizeStatus.values()) {
            assertThat(output).contains(status.getStatusMessage() + " - 0개");
        }
        assertThat(output).contains("총 수익률은 0.0%입니다.");
    }
}
