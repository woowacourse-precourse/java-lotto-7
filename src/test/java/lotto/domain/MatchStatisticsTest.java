package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchStatisticsTest {

    @DisplayName("당첨 결과를 올바르게 추가하고 출력한다.")
    @Test
    void testMatchStatistics() {
        MatchStatistics matchStatistics = new MatchStatistics();
        List<Lotto> tickets = Arrays.asList(
                new Lotto(Arrays.asList(17, 35, 12, 30, 34, 26)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(17, 35, 12, 37, 34, 26))
        );

        WinningNumber winningNumber = new WinningNumber(Arrays.asList(17, 35, 12, 37, 34, 26), 30);

        matchStatistics.calculateMatches(tickets, winningNumber);

        matchStatistics.printMatchResults();

        assertThat(matchStatistics.getMatchResults().get("3개 일치 (5,000원)")).isEqualTo(0);
        assertThat(matchStatistics.getMatchResults().get("4개 일치 (50,000원)")).isEqualTo(0);
        assertThat(matchStatistics.getMatchResults().get("5개 일치 (1,500,000원)")).isEqualTo(0);
        assertThat(matchStatistics.getMatchResults().get("5개 일치, 보너스 볼 일치 (30,000,000원)")).isEqualTo(1);
        assertThat(matchStatistics.getMatchResults().get("6개 일치 (2,000,000,000원)")).isEqualTo(1);
    }


}
