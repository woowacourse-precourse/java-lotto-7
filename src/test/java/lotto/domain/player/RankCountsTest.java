package lotto.domain.player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.constant.Rank;

@DisplayName("RankCounts는")
class RankCountsTest {

    @ParameterizedTest
    @MethodSource("countRankCounts")
    void 당첨_개수를_올바르게_센다() {
        RankCounts rankCounts = new RankCounts();
        rankCounts.add(Rank.FIRST);
        rankCounts.add(Rank.FIRST);
        RankCounts.RankCount rankCountList = rankCounts.getAll()
            .stream()
            .filter(rankCount -> rankCount.rank() == Rank.FIRST)
            .findAny()
            .get();
        assertThat(rankCountList.count()).isEqualTo(2);
    }

    private static Stream<Arguments> countRankCounts() {
        return Stream.of(
            Arguments.of(Rank.FIRST, 3),
            Arguments.of(Rank.SECOND, 4),
            Arguments.of(Rank.THIRD, 5),
            Arguments.of(Rank.FOURTH, 6),
            Arguments.of(Rank.FIFTH, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("calculateTotalPrice")
    void 총_상금을_올바르게_계산한다(List<Rank> ranks) {
        RankCounts rankCounts = new RankCounts();
        ranks.forEach(rankCounts::add);
        long totalPrice = ranks.stream()
            .mapToLong(Rank::getPrice)
            .sum();
        assertThat(rankCounts.totalPrice()).isEqualTo(totalPrice);
    }

    private static Stream<List<Rank>> calculateTotalPrice() {
        return Stream.of(
            List.of(Rank.FIRST),
            List.of(Rank.FIRST, Rank.SECOND),
            List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD),
            List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH),
            List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH),
            List.of(Rank.FIRST, Rank.FIRST, Rank.FIRST)
        );
    }
}
