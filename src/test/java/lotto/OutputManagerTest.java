package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class OutputManagerTest {
    @Test
    void 구입한_로또_개수_출력_테스트() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        OutputManager.printLottoCount(8);

        assertThat(outputStream.toString()).contains("8개를 구매했습니다.");

        System.setOut(System.out);
    }

    @Test
    void 구입한_로또_번호_목록_출력_테스트() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<List<Integer>> lottoTickets = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );

        OutputManager.printLottoTickets(lottoTickets);

        String actualOutput = outputStream.toString();
        assertThat(actualOutput).contains(
                "[8, 21, 23, 41, 42, 43]",
                "[3, 5, 11, 16, 32, 38]"
        );

        System.setOut(System.out);
    }

    @Test
    void 당첨_통계_출력_테스트() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Map<MatchCountMessage, Integer> winningStatistics = Map.of(
                MatchCountMessage.THREE_MATCH, 1,
                MatchCountMessage.FOUR_MATCH, 0,
                MatchCountMessage.FIVE_MATCH, 0,
                MatchCountMessage.FIVE_MATCH_WITH_BONUS, 0,
                MatchCountMessage.SIX_MATCH, 0
        );

        OutputManager.printWinningStatistics(winningStatistics);

        String actualOutput = outputStream.toString();
        assertThat(actualOutput).contains(
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );

        System.setOut(System.out);
    }

    @Test
    void 수익률_출력_테스트() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        double profitRate = 62.5;
        OutputManager.printProfitRate(profitRate);

        assertThat(outputStream.toString()).contains("총 수익률은 62.5%입니다.");

        System.setOut(System.out);
    }

}

