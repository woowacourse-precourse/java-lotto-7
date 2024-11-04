package lotto.domain.player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constant.Rank;

@DisplayName("RankCounts는")
class RankCountsTest {

    @Test
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

    @Test
    void 총_상금을_올바르게_계산한다() {
        RankCounts rankCounts = new RankCounts();
        rankCounts.add(Rank.FIRST);
        rankCounts.add(Rank.SECOND);
        assertThat(rankCounts.totalPrice()).isEqualTo(Rank.FIRST.getPrice() + Rank.SECOND.getPrice());
    }
}
