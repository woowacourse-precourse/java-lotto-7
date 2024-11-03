package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoEarningService;
import lotto.service.LottoIssueService;
import lotto.service.LottoRankService;
import lotto.service.LottoSortService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoServiceTest {

    private final LottoIssueService lottoIssueService = new LottoIssueService();
    private final LottoSortService lottoSortService = new LottoSortService();
    private final LottoEarningService lottoEarningService = new LottoEarningService();
    private final LottoRankService lottoRankService = new LottoRankService();

    @DisplayName("지정된 수의 로또 발행 테스트")
    @Test
    void 로또_발행_개수_테스트() {
        // given : 발행할 로또 수
        int issueNumber = 5;

        // when : 로또 발행
        List<Lotto> lottos = lottoIssueService.issueLottos(issueNumber);

        // then : 발행된 로또의 개수가 issueNumber와 일치하는지 확인
        assertThat(lottos).hasSize(issueNumber);
    }

    @DisplayName("로또 번호 정렬 테스트")
    @Test
    void 로또_번호_정렬_테스트() {
        // given : 2개의 임의의 로또 발행
        List<Lotto> lottos = List.of(
                new Lotto(List.of(5, 3, 6, 1, 4, 2)),
                new Lotto(List.of(12, 8, 14, 9, 7, 11))
        );

        // when : 각 로또의 번호를 정렬하여 반환
        List<List<Integer>> sortedLottos = lottoSortService.sortLottos(lottos);

        // then : 각 로또의 번호가 오름차순으로 정렬되었는지 확인
        assertThat(sortedLottos.get(0)).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(sortedLottos.get(1)).containsExactly(7, 8, 9, 11, 12, 14);
    }

    @DisplayName("당첨 등수 집계 테스트")
    @Test
    void 로또_당첨_등수_집계_테스트() {
        // given : 당첨 번호와 보너스 번호 설정
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // 1등, 2등, 3등 각각에 해당하는 로또 발행
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        );

        // when : 각 로또별 당첨 횟수 계산
        int[] countRank = lottoRankService.countRank(lottos, winningNumbers, bonusNumber);

        // then : 등수별 당첨 횟수가 예상대로인지 확인
        assertThat(countRank[1]).isEqualTo(1);
        assertThat(countRank[2]).isEqualTo(1);
        assertThat(countRank[3]).isEqualTo(1);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void 로또_수익률_계산_테스트() {
        // given : 각 등수별 당첨 횟수를 설정 (1등 1회, 2등 1회, 나머지 0회)
        int[] countRank = {0, 1, 1, 0, 0, 0};

        // when : 수익률 계산
        double earningRate = lottoEarningService.calculateEarningRate(countRank);

        // then : 수익률이 예상되는 값인지 확인
        double expectedProfit = 2000000000 + 30000000;
        double expectedCost = (countRank[1] + countRank[2]) * 1000;
        double expectedRate = Math.round((expectedProfit / expectedCost) * 1000) / 10.0;
        assertThat(earningRate).isEqualTo(expectedRate);
    }


}
