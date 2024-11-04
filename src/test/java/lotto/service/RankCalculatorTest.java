package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RankCalculatorTest {

    private final RankCalculator rankCalculator = new RankCalculator();

    @Test
    @DisplayName("로또 티켓의 등수가 올바르게 계산되어야 한다.")
    void 로또_티켓의_등수가_올바르게_계산되어야_한다() {
        // 사용자 로또
        List<Lotto> userLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 6개 일치: 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),  // 5개 + 보너스: 2등
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),  // 4개: 4등
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)) // 3개: 5등
        );

        // 당첨 결과
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoResult winningResult = new LottoResult(winningNumbers, bonusNumber);

        // 등수 계산
        Map<Rank, Integer> rankCount = rankCalculator.calculateRanks(userLottos, winningResult);

        // 검증
        assertThat(rankCount.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCount.get(Rank.SECOND)).isEqualTo(1);
        assertThat(rankCount.get(Rank.THIRD)).isEqualTo(0);
        assertThat(rankCount.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(rankCount.get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 티켓이 당첨되지 않았을 때 등수가 FAIL이어야 한다.")
    void 로또_티켓이_당첨되지_않았을_때_등수가_FAIL이어야_한다() {
        // RankCalculator 인스턴스 생성 (필요 시)
        RankCalculator rankCalculator = new RankCalculator();

        // 사용자 로또
        List<Lotto> userLottos = Arrays.asList(
                new Lotto(Arrays.asList(10, 20, 30, 40, 41, 42))  // 당첨 번호와 일치 없음
        );

        // 당첨 결과
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoResult winningResult = new LottoResult(winningNumbers, bonusNumber);

        // 등수 계산
        Map<Rank, Integer> rankCount = rankCalculator.calculateRanks(userLottos, winningResult);

        // 검증
        for (Rank rank : Rank.values()) {
            if (rank == Rank.FAIL) {
                assertThat(rankCount.get(rank)).isEqualTo(1);
            } else {
                assertThat(rankCount.get(rank)).isEqualTo(0);
            }
        }
    }
}