package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    void 구매한_로또의_수익률을_계산한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    Lottos lottos = new Lottos(List.of(
                            new Lotto(List.of(1, 2, 3, 27, 28, 29)),
                            new Lotto(List.of(30, 31, 32, 33, 34, 35)),
                            new Lotto(List.of(36, 37, 38, 39, 40, 41))
                    ));
                    Lotto drawedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                    BonusNumber bonusNumber = new BonusNumber(8);
                    WinningLotto winningLotto = new WinningLotto(drawedLotto, bonusNumber);
                    double percent = Math.round(lottos.calculateProfit(winningLotto) * 1000) / 10.0;
                    assertThat(percent).isEqualTo(166.7);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(6, 7, 8, 9, 10, 11),
                List.of(12, 13, 14, 15, 16, 17),
                List.of(18, 19, 20, 21, 22, 23)
        );
    }
}
