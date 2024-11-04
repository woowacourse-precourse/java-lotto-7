package lotto.domain.WinningLotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class WinningLottoCounterTest {
    private WinningLottoCounter winningLottoCounter;

    @BeforeEach
    void 초기화() {
        winningLottoCounter = new WinningLottoCounter();
    }

    @Test
    void 초기화_테스트() {
        Map<WinningLotto, Integer> counts = winningLottoCounter.getCounts();
        for (WinningLotto lotto : WinningLotto.values()) {
            Assertions.assertThat(counts.get(lotto))
                    .as(lotto + "의 초기 카운트는 0이어야 합니다.")
                    .isEqualTo(0);
        }
    }

    @Test
    void 카운트_증가_테스트() {
        winningLottoCounter.incrementCount(WinningLotto.FIVE_MATCH);
        winningLottoCounter.incrementCount(WinningLotto.FIVE_MATCH_BONUS);
        winningLottoCounter.incrementCount(WinningLotto.FIVE_MATCH);
        winningLottoCounter.incrementCount(WinningLotto.SIX_MATCH);
        winningLottoCounter.incrementCount(WinningLotto.NO_MATCH);
        winningLottoCounter.incrementCount(WinningLotto.NO_MATCH);

        Map<WinningLotto, Integer> counts = winningLottoCounter.getCounts();

        Assertions.assertThat(counts.get(WinningLotto.NO_MATCH))
                .as("NO_MATCH의 카운트는 2이어야 합니다.")
                .isEqualTo(2);
        Assertions.assertThat(counts.get(WinningLotto.THREE_MATCH))
                .as("THREE_MATCH의 카운트는 0이어야 합니다.")
                .isEqualTo(0);
        Assertions.assertThat(counts.get(WinningLotto.FOUR_MATCH))
                .as("FOUR_MATCH의 카운트는 0이어야 합니다.")
                .isEqualTo(0);
        Assertions.assertThat(counts.get(WinningLotto.FIVE_MATCH))
                .as("FIVE_MATCH의 카운트는 2이어야 합니다.")
                .isEqualTo(2);
        Assertions.assertThat(counts.get(WinningLotto.FIVE_MATCH_BONUS))
                .as("FIVE_MATCH_BONUS의 카운트는 1이어야 합니다.")
                .isEqualTo(1);
        Assertions.assertThat(counts.get(WinningLotto.SIX_MATCH))
                .as("SIX_MATCH의 카운트는 1이어야 합니다.")
                .isEqualTo(1);
    }
}
