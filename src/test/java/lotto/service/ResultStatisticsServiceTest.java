package lotto.service;

import lotto.constant.Rank;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultStatisticsServiceTest {
    private ResultStatisticsService resultStatistics;

    @BeforeEach
    void setUp() {
        resultStatistics = ResultStatisticsService.getInstance();
    }

    @DisplayName("당첨 번호 일치 개수 계산")
    @Test
    void countMatches_테스트() {
        // given
        Lotto purchasedLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        // when
        int matchCount = resultStatistics.countMatches(purchasedLotto, winningLotto);

        // then
        Assertions.assertThat(matchCount).isEqualTo(3);  // 1,2,3 세 개 일치
    }

    @DisplayName("보너스 번호 일치 여부 확인")
    @Test
    void isBonusMatched_테스트() {
        // given
        Lotto purchasedLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        winningLotto.setBonusNumber(6);

        // when
        boolean isMatched = resultStatistics.isBonusMatched(purchasedLotto, winningLotto);

        // then
        Assertions.assertThat(isMatched).isTrue();
    }

    @DisplayName("당첨 통계 수집")
    @Test
    void collectWinningStatistics_테스트() {
        // given
        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),    // 6개 일치 (1등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),    // 5개 일치 + 보너스 (2등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),    // 5개 일치 (3등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8))     // 4개 일치 (4등)
        );

        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningLotto.setBonusNumber(7);

        // when
        Map<Rank, Integer> statistics = resultStatistics.collectWinningStatistics(purchasedLottos, winningLotto);

        // then
        Assertions.assertThat(statistics.get(Rank.FIRST)).isEqualTo(1);
        Assertions.assertThat(statistics.get(Rank.SECOND)).isEqualTo(1);
        Assertions.assertThat(statistics.get(Rank.THIRD)).isEqualTo(1);
        Assertions.assertThat(statistics.get(Rank.FOURTH)).isEqualTo(1);
    }

    @DisplayName("당첨되지 않은 로또도 통계에 포함")
    @Test
    void collectWinningStatistics_미당첨_포함_테스트() {
        // given
        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),    // 모두 일치
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))  // 하나도 일치하지 않음
        );

        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningLotto.setBonusNumber(7);

        // when
        Map<Rank, Integer> statistics = resultStatistics.collectWinningStatistics(purchasedLottos, winningLotto);

        // then
        Assertions.assertThat(statistics.get(Rank.FIRST)).isEqualTo(1);
        Assertions.assertThat(statistics.get(Rank.NONE)).isEqualTo(1);
    }
}
