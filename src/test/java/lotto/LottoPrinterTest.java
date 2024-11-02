package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrinterTest {
    private ByteArrayOutputStream outputStream;
    private LottoResult lottoResult;
    private List<Lotto> issuedLottoTickets;
    private LottoStatistics lottoStatistics;
    private Lotto winningLotto;
    private LottoBonus lottoBonus;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        issuedLottoTickets = new ArrayList<>();
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoBonus = new LottoBonus(7, winningLotto);

        lottoStatistics = new LottoStatistics();
    }

    @Test
    @DisplayName("당첨 통계 출력 - 모든 순위 확인")
    void 당첨_통계_출력을_확인한다_모든_순위_확인() {
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 7))); // 2등
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 8))); // 3등
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 15, 8))); // 4등
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 14, 15, 8))); // 5등

        lottoResult = lottoStatistics.statistics(issuedLottoTickets, winningLotto, lottoBonus);

        LottoPrinter.printStatistics(lottoResult);

        String printedResult = outputStream.toString();

        assertThat(printedResult)
                .contains("3개 일치 (5,000원) - 1개")
                .contains("4개 일치 (50,000원) - 1개")
                .contains("5개 일치 (1,500,000원) - 1개")
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개")
                .contains("6개 일치 (2,000,000,000원) - 1개")
                .contains("총 수익률은 40631100.00%입니다.");
    }

    @Test
    @DisplayName("당첨_통계_출력을_확인한다_소숫점_출력_확인")
    void 당첨_통계_출력을_확인한다_소숫점_출력_확인() {
        lottoResult = new LottoResult();
        lottoResult.setRateReturn(12.34);

        LottoPrinter.printStatistics(lottoResult);
        String printedResult = outputStream.toString();

        assertThat(printedResult)
                .contains("12.34%")
                .doesNotContain("12.3%");
    }

    @Test
    @DisplayName("당첨_통계_출력을_확인한다_미당첨_확인")
    void 당첨_통계_출력을_확인한다_미당첨_확인() {
        lottoResult = new LottoResult();
        lottoResult.setRateReturn(0.00);

        LottoPrinter.printStatistics(lottoResult);
        String printedResult = outputStream.toString();

        assertThat(printedResult)
                .contains("- 0개")
                .contains("0.00%");
    }
}