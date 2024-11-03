package lotto.domain;

import lotto.wrapper.BonusNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = BonusNumber.of(7);
    }

    @DisplayName("당첨번호와 일치하는 Rank리스트를 반환한다.")
    @Test
    void 당첨번호와_보너스번호_일치_테스트() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))
        );
        Lottos lottos = new Lottos(lottoList);

        List<Rank> ranks = lottos.countMatchesWith(winningLotto, bonusNumber);

        assertThat(ranks).hasSize(5);
        assertThat(ranks.get(0)).isEqualTo(Rank.SIX_MATCHES);
        assertThat(ranks.get(1)).isEqualTo(Rank.THREE_MATCHES);
        assertThat(ranks.get(2)).isEqualTo(Rank.FIVE_MATCHES_WITH_BONUS);
        assertThat(ranks.get(3)).isEqualTo(Rank.FIVE_MATCHES);
        assertThat(ranks.get(4)).isEqualTo(Rank.NO_MATCH);
    }

}
