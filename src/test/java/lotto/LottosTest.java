package lotto;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    @DisplayName("로또 목록에서 각 Rank별로 당첨 통계를 계산한다.")
    void 로또_목록에서_Rank별로_통계를_계산한다() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // FIRST
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // SECOND
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // THIRD
                new Lotto(List.of(1, 2, 3, 4, 8, 9)), // FOURTH
                new Lotto(List.of(1,2,3,8,9,10)) // FIFTH
        ));

        Map<Rank, Integer> statistics = lottos.calculateStatistics(winningLotto);

        assertThat(statistics.get(Rank.FIRST)).isEqualTo(1);
        assertThat(statistics.get(Rank.SECOND)).isEqualTo(1);
        assertThat(statistics.get(Rank.THIRD)).isEqualTo(1);
        assertThat(statistics.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(statistics.get(Rank.FIFTH)).isEqualTo(1);
    }
}
