package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.controller.LottoGame;
import lotto.domain.Lotto;
import lotto.domain.LottoGamePlayer;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameServiceTest {
    private LottoGameService lottoGameService;

    @BeforeEach
    void setUp() {
        lottoGameService = new LottoGameService();
    }

    @Test
    @DisplayName("구매한 로또 개수만큼 로또 번호가 생성되는지 확인")
    void 구매한_로또_개수만큼_로또_번호가_생성되는지_확인() {
        // given
        int purchaseCount = 5;

        // when
        List<Lotto> lottos = lottoGameService.generatePurchaserLottos(purchaseCount);

        // then
        assertThat(lottos).hasSize(purchaseCount);
    }

    @Test
    @DisplayName("각 로또 번호가 오름차순으로 정렬되어 생성되는지 확인")
    void 각_로또_번호가_오름차순으로_정렬되어_생성되는지_확인() {
        // given
        int purchaseCount = 3;

        // when
        List<Lotto> lottos = lottoGameService.generatePurchaserLottos(purchaseCount);

        // then
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).isSorted();
        }
    }

    @Test
    @DisplayName("당첨 통계가 올바르게 계산되는지 확인")
    void 당첨_통계가_올바르게_계산되는지_확인() {
        // given
        lottoGameService.generateWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> purchaserLottos = lottoGameService.generatePurchaserLottos(5);
        purchaserLottos.get(0).getNumbers().clear();
        purchaserLottos.get(0).getNumbers().addAll(List.of(1, 2, 3, 4, 5, 6)); // 6개 일치 (1등)

        purchaserLottos.get(1).getNumbers().clear();
        purchaserLottos.get(1).getNumbers().addAll(List.of(1, 2, 3, 4, 5, 7)); // 5개 + 보너스 일치 (2등)

        purchaserLottos.get(2).getNumbers().clear();
        purchaserLottos.get(2).getNumbers().addAll(List.of(1, 2, 3, 4, 5, 8)); // 5개 일치 (3등)

        purchaserLottos.get(3).getNumbers().clear();
        purchaserLottos.get(3).getNumbers().addAll(List.of(1, 2, 3, 4, 9, 10)); // 4개 일치 (4등)

        purchaserLottos.get(4).getNumbers().clear();
        purchaserLottos.get(4).getNumbers().addAll(List.of(1, 2, 3, 11, 12, 13)); // 3개 일치 (5등)

        // when
        Map<Rank, Integer> rankResult = lottoGameService.calculateRank();

        // then
        assertThat(rankResult.get(Rank.FIRST)).isEqualTo(1); // 6개 일치 (1등)
        assertThat(rankResult.get(Rank.SECOND)).isEqualTo(1); // 5개 + 보너스 일치 (2등)
        assertThat(rankResult.get(Rank.THIRD)).isEqualTo(1); // 5개 일치 (3등)
        assertThat(rankResult.get(Rank.FOURTH)).isEqualTo(1); // 4개 일치 (4등)
        assertThat(rankResult.get(Rank.FIFTH)).isEqualTo(1); // 3개 일치 (5등)
    }

    @Test
    @DisplayName("총 수익률이 올바르게 계산되는지 확인")
    void 총_수익률이_올바르게_계산되는지_확인() {
        // given
        lottoGameService.generateWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> purchaserLottos = lottoGameService.generatePurchaserLottos(5);
        purchaserLottos.get(0).getNumbers().clear();
        purchaserLottos.get(0).getNumbers().addAll(List.of(1, 2, 3, 4, 5, 6)); // 6개 일치 (1등)

        purchaserLottos.get(1).getNumbers().clear();
        purchaserLottos.get(1).getNumbers().addAll(List.of(1, 2, 3, 4, 5, 7)); // 5개 + 보너스 일치 (2등)

        purchaserLottos.get(2).getNumbers().clear();
        purchaserLottos.get(2).getNumbers().addAll(List.of(1, 2, 3, 4, 5, 8)); // 5개 일치 (3등)

        purchaserLottos.get(3).getNumbers().clear();
        purchaserLottos.get(3).getNumbers().addAll(List.of(1, 2, 3, 4, 9, 10)); // 4개 일치 (4등)

        purchaserLottos.get(4).getNumbers().clear();
        purchaserLottos.get(4).getNumbers().addAll(List.of(1, 2, 3, 11, 12, 13)); // 3개 일치 (5등)

        // when
        String profitRate = lottoGameService.calculateProfitRate();

        // then
        assertThat(profitRate).isNotEmpty();
    }
}
