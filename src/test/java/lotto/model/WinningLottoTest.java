package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    private final int bonusNumber = 7;
    private final WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

    @DisplayName("로또 번호가 모두 일치할 경우 1등이다.")
    @Test
    void 로또_번호가_모두_일치할_경우_1등이다() {
        assertSimpleTest(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Map<Rank, Integer> result = winningLotto.calculateResult(List.of(lotto));

            assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        });
    }

    @DisplayName("로또 번호가 5개 일치하고 보너스 번호가 일치할 경우 2등이다.")
    @Test
    void 로또_번호가_5개_일치하고_보너스_번호가_일치할_경우_2등이다() {
        assertSimpleTest(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            Map<Rank, Integer> result = winningLotto.calculateResult(List.of(lotto));

            assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        });
    }

    @DisplayName("로또 번호가 하나도 일치하지 않으면 낙첨이다.")
    @Test
    void 로또_번호가_하나도_일치하지_않으면_낙첨이다() {
        assertSimpleTest(() -> {
            Lotto lotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
            Map<Rank, Integer> result = winningLotto.calculateResult(List.of(lotto));

            assertThat(result.get(Rank.NONE)).isEqualTo(1);
        });
    }
}
