package lotto.domain;

import java.util.Map;
import lotto.wrapper.BonusNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LottosTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningLotto = WinningLotto.of(winningNumbers, BonusNumber.of(7));
    }

    @DisplayName("당첨번호와 일치하는 Rank리스트를 반환한다.")
    @Test
    void 당첨번호와_보너스번호_일치_테스트() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 6
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 6
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 5 + bonus
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 5 + bonus
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 5 + bonus
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // 5
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)), // 4
                new Lotto(Arrays.asList(1, 2, 40, 41, 42, 43)), // 2
                new Lotto(Arrays.asList(1, 2, 40, 41, 43, 44)) // 2
        );
        Lottos lottos = Lottos.of(lottoList);

        Map<Rank, Integer> result = lottos.countMatchesWith(winningLotto);

        Assertions.assertThat(result.get(Rank.SIX_MATCHES)).isEqualTo(2);
        Assertions.assertThat(result.get(Rank.FIVE_MATCHES_WITH_BONUS)).isEqualTo(3);
        Assertions.assertThat(result.get(Rank.FIVE_MATCHES)).isEqualTo(1);
        Assertions.assertThat(result.get(Rank.FOUR_MATCHES)).isEqualTo(1);
        Assertions.assertThat(result.get(Rank.THREE_MATCHES)).isEqualTo(0);
        Assertions.assertThat(result.get(Rank.NO_MATCH)).isEqualTo(2);
    }

}
