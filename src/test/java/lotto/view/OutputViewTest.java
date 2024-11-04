package lotto.view;

import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("로또 구매 정보를 출력한다.")
    @Test
    void 로또_구매_정보를_출력한다() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38))
        );

        OutputView.printPurchaseInfo(lottos);
        String output = outputStream.toString();

        assertThat(output).contains("2개를 구매했습니다.");
        assertThat(output).contains("[8, 21, 23, 41, 42, 43]");
        assertThat(output).contains("[3, 5, 11, 16, 32, 38]");
    }

    @DisplayName("당첨 통계를 출력한다.")
    @Test
    void 당첨_통계를_출력한다() {
        List<Integer> matchCounts = List.of(1, 0, 0, 0, 0);
        double profitRate = 62.5;

        OutputView.printWinningStatistics(matchCounts, profitRate);
        String output = outputStream.toString();

        assertThat(output).contains("3개 일치 (5,000원) - 1개");
        assertThat(output).contains("총 수익률은 62.5%");
    }
}
