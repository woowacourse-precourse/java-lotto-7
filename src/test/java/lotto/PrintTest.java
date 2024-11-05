package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrintTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent)); // 표준 출력을 ByteArrayOutputStream으로 변경
    }

    @Test
    @DisplayName("로또 구매 내역 출력 테스트")
    void printLottosTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        Print.printLottos(lottos);

        String expectedOutput = String.format("%n2개를 구매했습니다.%n[1, 2, 3, 4, 5, 6]%n[7, 8, 9, 10, 11, 12]%n");
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("당첨 통계 출력 테스트")
    void printStatisticsTest() {
        LottoStatistics statistics = new LottoStatistics();
        statistics.recordWin(LottoResult.FIVE_MATCH);
        statistics.recordWin(LottoResult.FOUR_MATCH);
        statistics.addCost(3000);

        Print.printStatistics(statistics);

        String expectedOutput = String.format(
                "%n당첨 통계%n---------%n" +
                        "3개 일치 (5,000원) - 0개%n" +
                        "4개 일치 (50,000원) - 1개%n" +
                        "5개 일치 (1,500,000원) - 1개%n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개%n" +
                        "6개 일치 (2,000,000,000원) - 0개%n" +
                        "총 수익률은 %.1f%%입니다.%n", statistics.calculateYield()
        );
        assertThat(outContent.toString().trim()).isEqualTo(expectedOutput.trim());
    }
}
