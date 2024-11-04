package domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankResultTest {

    @DisplayName("당첨 결과를 등수별로 카운팅하여 구분한다.")
    @Test
    void countingRank() {
        // given
        List<Rank> ranks = List.of(
                Rank.NO_RANK, Rank.FIRST, Rank.THIRD, Rank.FIFTH, Rank.THIRD, Rank.SECOND, Rank.SECOND);

        // when
        RankResult rankResult = new RankResult(ranks);

        // then
        assertAll(
                () -> assertEquals(rankResult.getRankResult().get(Rank.NO_RANK), 1),
                () -> assertEquals(rankResult.getRankResult().get(Rank.FIRST), 1),
                () -> assertEquals(rankResult.getRankResult().get(Rank.SECOND), 2),
                () -> assertEquals(rankResult.getRankResult().get(Rank.THIRD), 2),
                () -> assertEquals(rankResult.getRankResult().get(Rank.FIFTH), 1)
        );
    }
}
