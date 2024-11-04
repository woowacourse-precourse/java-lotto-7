package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("로또를 구매한 수만큼 생성하는지 테스트")
    void generateLottosTest() {
        lottoService.generateLottos(5000);
        List<Lotto> lottos = lottoService.getLottos();
        assertThat(lottos).hasSize(5);
    }

    @Test
    @DisplayName("당첨 결과를 올바르게 계산하는지 테스트")
    void calculateResultsTest() {
        lottoService.generateLottos(5000);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)), // 4등
                new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)) // 5등
        );
        lottoService.getLottos().clear();
        lottoService.getLottos().addAll(lottos);

        WinningLotto winningLotto = new WinningLotto(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        Map<Rank, Integer> results = lottoService.calculateResults(winningLotto);

        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.THIRD)).isEqualTo(1);
        assertThat(results.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(results.get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 올바르게 계산하는지 테스트")
    void calculateProfitRateTest() {
        lottoService.generateLottos(5000);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        lottoService.getLottos().clear();
        lottoService.getLottos().addAll(lottos);

        WinningLotto winningLotto = new WinningLotto(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        double profitRate = lottoService.calculateProfitRate(winningLotto, 5000);
        assertThat(profitRate).isEqualTo(40000000.0);
    }
}
