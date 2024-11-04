package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource("generateEachLottoData")
    void 각_로또에_대한_당첨_결과를_잘_계산하는지_확인한다(List<Lotto> userLotto, Rank rank, int expectedRankCount) {
        Lottos userLottos = Lottos.from(userLotto);
        LottoResult lottoResult = LottoResult.of(userLottos, winNumber);
        Map<Rank, Integer> rankDistribution = lottoResult.calculateRankDistribution();

        assertThat(rankDistribution.get(rank)).isEqualTo(expectedRankCount);
    }

    static Stream<Arguments> generateEachLottoData() {
        return Stream.of(
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                        , Rank.FIRST_RANK
                        , 1),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)))
                        , Rank.SECOND_RANK
                        , 1),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)))
                        , Rank.THIRD_RANK
                        , 1),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 7, 8)))
                        , Rank.FOURTH_RANK
                        , 1),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 9, 10, 11)))
                        , Rank.FIFTH_RANK
                        , 1),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 10, 11, 12, 13)))
                        , Rank.NO_RANK
                        , 1)
        );
    }
}
