package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    private final Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final BonusNumber bonusNumber = BonusNumber.from("7");
    private final WinNumber winNumber = WinNumber.of(winningNumber, bonusNumber);

    Lottos lottos = Lottos.from(List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 8)),
            new Lotto(List.of(1, 2, 3, 4, 5, 8)),
            new Lotto(List.of(1, 2, 3, 4, 10, 11)),
            new Lotto(List.of(1, 2, 3, 15, 16, 17)),
            new Lotto(List.of(21, 22, 23, 24, 25, 26))
    ));

    @Test
    void 여러_로또에_대한_당첨_결과를_잘_계산하는지_확인한다() {
        LottoResult lottoResult = LottoResult.of(lottos, winNumber);
        Map<Rank, Integer> rankDistribution = lottoResult.calculateRankDistribution();

        assertThat(rankDistribution.get(Rank.FIRST_RANK)).isEqualTo(2);
        assertThat(rankDistribution.get(Rank.SECOND_RANK)).isEqualTo(1);
        assertThat(rankDistribution.get(Rank.THIRD_RANK)).isEqualTo(2);
        assertThat(rankDistribution.get(Rank.FOURTH_RANK)).isEqualTo(1);
        assertThat(rankDistribution.get(Rank.FIFTH_RANK)).isEqualTo(1);
        assertThat(rankDistribution.get(Rank.NO_RANK)).isEqualTo(1);
    }
}
