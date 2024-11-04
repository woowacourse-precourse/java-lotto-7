package lotto.domain.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RankTest {

    @Nested
    @DisplayName("Rank.from 메서드")
    class From메서드 {

        @ParameterizedTest
        @MethodSource("provideMatchCountAndBonusForRank")
        @DisplayName("일치 개수와 보너스 여부에 따라 올바른 Rank를 반환한다.")
        void 일치개수와_보너스여부로_Rank반환_검증(int matchCount, boolean hasBonus, Rank expectedRank) {
            Rank rank = Rank.from(matchCount, hasBonus);

            assertThat(rank).isEqualTo(expectedRank);
        }

        private static Stream<Arguments> provideMatchCountAndBonusForRank() {
            return Stream.of(
                    Arguments.of(3, false, Rank.THREE_MATCH),
                    Arguments.of(4, false, Rank.FOUR_MATCH),
                    Arguments.of(5, false, Rank.FIVE_MATCH),
                    Arguments.of(5, true, Rank.FIVE_MATCH_WITH_BONUS),
                    Arguments.of(6, false, Rank.SIX_MATCH),
                    Arguments.of(2, false, Rank.NO_MATCH),
                    Arguments.of(0, false, Rank.NO_MATCH)
            );
        }
    }

    @Nested
    @DisplayName("Rank의 기본 속성")
    class Rank기본속성 {

        @ParameterizedTest
        @MethodSource("provideRanksForAttributesTest")
        @DisplayName("Rank의 matchCount, hasBonus, prize가 예상대로 설정된다.")
        void Rank_속성_검증(Rank rank, int expectedMatchCount, boolean expectedHasBonus, int expectedPrize) {
            assertThat(rank.getMatchCount()).isEqualTo(expectedMatchCount);
            assertThat(rank.hasBonus()).isEqualTo(expectedHasBonus);
            assertThat(rank.getPrize()).isEqualTo(expectedPrize);
        }

        private static Stream<Arguments> provideRanksForAttributesTest() {
            return Stream.of(
                    Arguments.of(Rank.THREE_MATCH, 3, false, 5_000),
                    Arguments.of(Rank.FOUR_MATCH, 4, false, 50_000),
                    Arguments.of(Rank.FIVE_MATCH, 5, false, 1_500_000),
                    Arguments.of(Rank.FIVE_MATCH_WITH_BONUS, 5, true, 30_000_000),
                    Arguments.of(Rank.SIX_MATCH, 6, false, 2_000_000_000),
                    Arguments.of(Rank.NO_MATCH, 0, false, 0)
            );
        }
    }
}
