package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @Test
    void 등수_추가() {
        lottoResult.addRank(Rank.FIRST);
        lottoResult.addRank(Rank.SECOND);
        lottoResult.addRank(Rank.SECOND);

        Map<Rank, Integer> expectedRankCount = new HashMap<>();
        expectedRankCount.put(Rank.FIRST, 1);
        expectedRankCount.put(Rank.SECOND, 2);
        expectedRankCount.put(Rank.NONE, 0);
        expectedRankCount.put(Rank.THIRD, 0);
        expectedRankCount.put(Rank.FOURTH, 0);
        expectedRankCount.put(Rank.FIFTH, 0);

        assertEquals(expectedRankCount, lottoResult.getRankCount());
    }

    @Test
    void 랭크_카운트_초기화() {
        Map<Rank, Integer> rankCount = lottoResult.getRankCount();
        for (Rank rank : Rank.values()) {
            assertEquals(0, rankCount.get(rank));
        }
    }

    @Test
    void 총상금계산_테스트() {
        lottoResult.addRank(Rank.FIFTH);
        lottoResult.addRank(Rank.SECOND);
        lottoResult.addRank(Rank.THIRD);
        lottoResult.addRank(Rank.THIRD);

        int expectedTotalPrizeMoney = (5000) + (30000000) + (2 * 1500000);
        assertEquals(expectedTotalPrizeMoney, lottoResult.calculateTotalPrizeMoney());
    }

    @Test
    void null_랭크_추가_테스트() {
        lottoResult.addRank(null);
        Map<Rank, Integer> expectedRankCount = new HashMap<>();
        expectedRankCount.put(Rank.FIRST, 0);
        expectedRankCount.put(Rank.SECOND, 0);
        expectedRankCount.put(Rank.NONE, 0);
        expectedRankCount.put(Rank.THIRD, 0);
        expectedRankCount.put(Rank.FOURTH, 0);
        expectedRankCount.put(Rank.FIFTH, 0);

        assertEquals(expectedRankCount, lottoResult.getRankCount());
    }

    @Test
    void 총상금계산_없는경우_테스트() {
        assertEquals(0, lottoResult.calculateTotalPrizeMoney());
    }
}
