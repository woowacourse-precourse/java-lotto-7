package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoCheckService 테스트")
public class LottoCheckServiceTest {

    private LottoCheckService lottoCheckService;

    @BeforeEach
    void setUp() {

        lottoCheckService = new LottoCheckService();
    }

    @Test
    void 구매한_로또들과_당첨로또를_비교하여_등수를_반환한다() {
        //given
        Lottos lottos = new Lottos(List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 8)),
            new Lotto(List.of(1, 2, 3, 4, 8, 9)),
            new Lotto(List.of(1, 2, 3, 8, 9, 10)),
            new Lotto(List.of(1, 2, 8, 9, 10, 11))
        ));

        WinningLotto winningLotto = new WinningLotto(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            7
        );

        List<LottoRank> expectedRank = List.of(
            LottoRank.FIRST,
            LottoRank.SECOND,
            LottoRank.THIRD,
            LottoRank.FOURTH,
            LottoRank.FIFTH,
            LottoRank.MISS
        );

        //when
        List<LottoRank> ranks = lottoCheckService.checkRanks(winningLotto, lottos);

        //then
        assertThat(ranks).isEqualTo(expectedRank);
    }

}
