package lotto.sevice;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.util.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private LottoGenerator generator;
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        generator = new LottoGenerator();
        lottoService = new LottoService();
    }

    @Test
    void 주어진_금액에_따라_로또를_생성한다() {
        List<Lotto> issuedLottos = new ArrayList<>();
        int purchaseCount = 8;

        for (int i = 0; i < purchaseCount; i++) {
            issuedLottos.add(generator.generate());
        }

        assertThat(issuedLottos.size()).isEqualTo(8);

    }

    @Test
    void 당첨_결과_및_수익률_계산() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), //1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), //2등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), //3등
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), //4등
                new Lotto(Arrays.asList(1, 2, 3, 20, 21, 22)) //5등
        );

        WinningLotto winningLotto = new WinningLotto(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7
        );

        LottoResult result = lottoService.winningProgress(lottos, winningLotto);
        Map<Rank, Integer> ranks = result.getRanks();

        assertThat(ranks.get(Rank.FIRST)).isEqualTo(1);
        assertThat(ranks.get(Rank.SECOND)).isEqualTo(1);
        assertThat(ranks.get(Rank.THIRD)).isEqualTo(1);
        assertThat(ranks.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(ranks.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(ranks.get(Rank.NONE)).isNull();

        double expectedProfitRate = (2_000_000_000 + 30_000_000 + 1_500_000 + 50_000 + 5_000) / (double) (5 * 1_000) * 100;
        assertThat(result.getProfitRate()).isEqualTo(expectedProfitRate);
    }
}