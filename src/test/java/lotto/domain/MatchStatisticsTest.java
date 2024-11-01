package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchStatisticsTest {
    private MatchStatistics matchStatistics;
    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        matchStatistics = new MatchStatistics();
        winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    }

    @Test
    @DisplayName("당첨 결과를 추가하고 통계가 올바르게 업데이트되는지 확인")
    void addMatchResult_ShouldUpdateStatistics() {
        matchStatistics.addMatchResult(MatchResult.THREE_MATCH, 2);
        matchStatistics.addMatchResult(MatchResult.FOUR_MATCH, 1);
        matchStatistics.addMatchResult(MatchResult.FIVE_MATCH, 3);
        matchStatistics.addMatchResult(MatchResult.SIX_MATCH, 1);

        assertThat(matchStatistics.getMatchResults().get(MatchResult.THREE_MATCH.getDescription())).isEqualTo(2);
        assertThat(matchStatistics.getMatchResults().get(MatchResult.FOUR_MATCH.getDescription())).isEqualTo(1);
        assertThat(matchStatistics.getMatchResults().get(MatchResult.FIVE_MATCH.getDescription())).isEqualTo(3);
        assertThat(matchStatistics.getMatchResults().get(MatchResult.SIX_MATCH.getDescription())).isEqualTo(1);
    }

    @Test
    @DisplayName("지출 금액을 설정하고 총 수익률을 계산하는지 확인")
    void setTotalSpent_ShouldUpdateInvestmentAndCalculateReturnRate() {
        matchStatistics.setTotalSpent(10000);
        matchStatistics.addMatchResult(MatchResult.THREE_MATCH, 2);
        matchStatistics.addMatchResult(MatchResult.FIVE_MATCH, 1);

        double profitRate = matchStatistics.getProfitRate();

        assertThat(profitRate).isGreaterThan(0);
    }

    @Test
    @DisplayName("입력한 로또 티켓으로 당첨 통계를 계산하는지 확인")
    void calculateMatches_ShouldCalculateCorrectly() {
        List<Lotto> tickets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12))
        );

        matchStatistics.calculateMatches(tickets, winningNumber);

        assertThat(matchStatistics.getMatchResults().get(MatchResult.SIX_MATCH.getDescription())).isEqualTo(1);
        assertThat(matchStatistics.getMatchResults().get(MatchResult.FIVE_MATCH_WITH_BONUS.getDescription())).isEqualTo(1);
        assertThat(matchStatistics.getMatchResults().get(MatchResult.FOUR_MATCH.getDescription())).isEqualTo(1);
        assertThat(matchStatistics.getMatchResults().get(MatchResult.THREE_MATCH.getDescription())).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률이 0일 때 계산되는지 확인")
    void calculateReturnRate_ShouldReturnZeroWhenNoInvestment() {
        assertThat(matchStatistics.getProfitRate()).isEqualTo(0);
    }
}
