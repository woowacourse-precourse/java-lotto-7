package lotto.domain.rank;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class LottoRanksTest {

    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 6개 일치
        Lotto lotto2 = new Lotto(List.of(12, 2, 3, 4, 5, 6)); // 5개 + 보너스 일치
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 8, 9)); // 4개 일치
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 10, 11, 12)); // 3개 일치

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        lottos = List.of(lotto1, lotto2, lotto3, lotto4);
        winningLotto = new WinningLotto(winningNumbers);
    }

    @Test
    void 각_로또에_대한_등수를_정확히_생성한다() {
        // given
        LottoRanks lottoRanks = new LottoRanks(lottos, winningLotto);

        // when
        List<LottoRank> ranks = lottoRanks.displayLottoRanks();

        // then
        assertThat(ranks).hasSize(4);
        assertThat(ranks.get(0).getLottoCount()).isEqualTo(6);
        assertThat(ranks.get(1).getLottoCount()).isEqualTo(5);
        assertThat(ranks.get(2).getLottoCount()).isEqualTo(4);
        assertThat(ranks.get(3).getLottoCount()).isEqualTo(3);
    }
}
