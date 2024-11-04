package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Ranking;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService(((min, max, size) -> List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 로또를_구입한다() {
        //given
        Money money = Money.from(5000);

        //when
        Lottos lottos = lottoService.purchaseLottos(money);

        //then
        assertThat(lottos.getLottos()).hasSize(5)
                .extracting("numbers")
                .containsExactly(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6)
                );
    }

    @Test
    void 로또_결과를_계산한다() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lotto lotto6 = new Lotto(List.of(1, 2, 9, 10, 11, 12));
        Lotto lotto7 = new Lotto(List.of(1, 13, 9, 10, 11, 12));
        Lottos lottos = Lottos.from(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7));
        WinningLotto winningLotto = new WinningLotto(lotto1, new Bonus(7));

        //when
        LottoResult lottoResult = lottoService.calculateLottoResult(lottos, winningLotto);

        //then
        Map<Ranking, Integer> expectedResults = Map.of(
                Ranking.FIRST, 1,
                Ranking.SECOND, 1,
                Ranking.THIRD, 1,
                Ranking.FOURTH, 1,
                Ranking.FIFTH, 1,
                Ranking.MISS, 2
        );
        assertThat(round(lottoResult.getRevenue())).isEqualTo(29022214.3);
        assertThat(lottoResult.getResults()).isEqualTo(expectedResults);
    }

    private double round(double revenue) {
        return Math.round(revenue * 10) / 10.0;
    }
}