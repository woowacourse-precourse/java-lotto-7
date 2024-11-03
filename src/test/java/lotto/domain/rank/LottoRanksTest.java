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
    void 각_로또에_대한_당첨_개수를_생성한다() {
        // given
        LottoRanks lottoRanks = new LottoRanks(lottos, winningLotto);

        // when
        List<Integer> sortedRanks = lottoRanks.provideSortedRankCounts();

        // then
        assertThat(sortedRanks.get(0)).isEqualTo(1);
        assertThat(sortedRanks.get(1)).isEqualTo(1);
        assertThat(sortedRanks.get(2)).isEqualTo(0);
        assertThat(sortedRanks.get(3)).isEqualTo(1);
        assertThat(sortedRanks.get(4)).isEqualTo(1);
    }

    @Test
    void 전체_당첨금액을_계산한다() {
        // given
        LottoRanks lottoRanks = new LottoRanks(lottos, winningLotto);
        double expected = 2030055000.0;

        // when
        double actual = lottoRanks.sumLottoPrice();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
