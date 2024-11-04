package lotto.domain.rank;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.rank.vo.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FixedWinningLotto implements WinningLotto {
    private final List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

    @Override
    public List<Integer> basicNumbers() {
        return numbers;
    }

    @Override
    public int bonusNumber() {
        return 7;
    }
}

class RankResultTest {
    private final WinningLotto winningLotto = new FixedWinningLotto();
    private final List<Lotto> lottos = new ArrayList<>() {{
        add(new Lotto(winningLotto.basicNumbers()));
        add(new Lotto(List.of(4, 5, 6, 7, 8, 9)));
    }};

    @Test
    @DisplayName("주어진 로또 묶음과 당첨 번호를 통해 총 수익을 계산할 수 있다.")
    void 수익_계산() {
        // given

        // when
        RankResult rankResult = RankResult.from(lottos, winningLotto);

        // then
        assertThat(rankResult.getRevenue()).isEqualTo(Rank.FIRST.getPrize() + Rank.FIFTH.getPrize());
    }

    @Test
    @DisplayName("주어진 로또 묶음과 당첨 번호를 통해 올바른 결과를 출력할 수 있다.")
    void 결과_출력() {
        // given

        // when
        RankResult rankResult = RankResult.from(lottos, winningLotto);

        // then
        assertThat(rankResult.toString()).contains("3개 일치 (5,000원) - 1개", "6개 일치 (2,000,000,000원) - 1개");
    }
}