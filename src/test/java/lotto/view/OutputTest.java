package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningKind;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static lotto.util.Util.cashFormat;
import static org.assertj.core.api.Assertions.assertThat;

class OutputTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }

    @DisplayName("구매한 로또 목록을 올바르게 출력하는지 확인")
    @Test
    void purchasedLottos() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        Output.purchasedLottos(lottos);
        assertThat(outContent.toString().trim()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]"
        );
    }

    @DisplayName("당첨 결과를 올바르게 출력하는지 확인")
    @Test
    void wonResult() {
        Map<WinningKind, Integer> lottoResult = Map.of(
                WinningKind.MATCH_3, 1,
                WinningKind.MATCH_4, 0,
                WinningKind.MATCH_5, 0,
                WinningKind.MATCH_5_BONUS, 1,
                WinningKind.MATCH_6, 0
        );
        Output.wonResult(lottoResult);
        String expectedOutput = String.format(
                "3개 일치 (%s원) - 1개\n" +
                        "4개 일치 (%s원) - 0개\n" +
                        "5개 일치 (%s원) - 0개\n" +
                        "5개 일치, 보너스 볼 일치 (%s원) - 1개\n" +
                        "6개 일치 (%s원) - 0개",
                cashFormat(WinningKind.MATCH_3.getPrize()),
                cashFormat(WinningKind.MATCH_4.getPrize()),
                cashFormat(WinningKind.MATCH_5.getPrize()),
                cashFormat(WinningKind.MATCH_5_BONUS.getPrize()),
                cashFormat(WinningKind.MATCH_6.getPrize())
        );
        assertThat(outContent.toString().trim()).isEqualTo(expectedOutput);
    }

    @DisplayName("수익률을 올바르게 출력하는지 확인")
    @Test
    void yield() {
        Output.yield(62.52);
        assertThat(outContent.toString().trim()).isEqualTo("총 수익률은 62.5%입니다.");
    }

}