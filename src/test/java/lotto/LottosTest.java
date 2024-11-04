package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningNumbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {
    @ParameterizedTest
    @MethodSource("winningParameters")
    void 당첨번호와_구매한_로또가_일치하는지_확인한다(List<Lotto> lottoList, WinningNumbers winningNumbers, List<Rank> expectedRanks) {
        // given
        Lottos lottos = new Lottos(lottoList);

        // when
        List<Rank> ranks = lottos.compareWithWinLotto(winningNumbers);

        // then
        assertThat(ranks.size()).isEqualTo(lottoList.size());
        for (Rank expectedRank : expectedRanks) {
            assertTrue(ranks.contains(expectedRank));
        }
    }
    static Stream<Object[]> winningParameters() {
        return Stream.of(
                new Object[] {
                        List.of(new Lotto(List.of(6, 34, 2, 7, 9, 10)), new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                        new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 45)), new Bonus(10)),
                        List.of(Rank.THIRD)
                },
                new Object[] {
                        List.of(new Lotto(List.of(11, 12, 13, 14, 15, 16)), new Lotto(List.of(17, 18, 19, 20, 21, 22))),
                        new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 45)), new Bonus(10)),
                        List.of(Rank.NONE)
                },
                new Object[] {
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 45)), new Lotto(List.of(1, 2, 3, 4, 5, 10))),
                        new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 45)), new Bonus(10)),
                        List.of(Rank.FIRST, Rank.SECOND)
                },
                new Object[] {
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                                new Lotto(List.of(1, 2, 3, 4, 6, 10)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                                new Lotto(List.of(6, 7, 8, 9, 10, 11))),
                        new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 45)), new Bonus(10)),
                        List.of(Rank.SECOND, Rank.FOURTH, Rank.THIRD, Rank.NONE)
                }
        );
    }
}