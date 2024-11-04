package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class PrizeResultTest {

    @DisplayName("각 로또의 당첨 금액을 구한다.")
    @Test
    void 당첨금액_계산() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                new Lotto(List.of(1, 2, 3, 11, 12, 13))
        );

        PrizeResult prizeResult = new PrizeResult(lottos, winningLotto);

        assertThat(prizeResult.getPrizeCount().get(Prize.FIRST)).isEqualTo(1);
        assertThat(prizeResult.getPrizeCount().get(Prize.SECOND)).isEqualTo(1);
        assertThat(prizeResult.getPrizeCount().get(Prize.THIRD)).isEqualTo(1);
        assertThat(prizeResult.getPrizeCount().get(Prize.FOURTH)).isEqualTo(1);
        assertThat(prizeResult.getPrizeCount().get(Prize.FIFTH)).isEqualTo(1);
    }
}
