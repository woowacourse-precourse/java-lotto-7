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
    void 등수_추가_테스트() {
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
    void toString_테스트() {
        lottoResult.addRank(Rank.THIRD);
        lottoResult.addRank(Rank.THIRD);
        lottoResult.addRank(Rank.FOURTH);
        lottoResult.addRank(Rank.FIFTH);

        String expectedOutput =
                "3개 일치 (5,000원) - 1개\n" +
                        "4개 일치 (50,000원) - 1개\n" +
                        "5개 일치 (1,500,000원) - 2개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                        "6개 일치 (2,000,000,000원) - 0개\n";

        assertEquals(expectedOutput, lottoResult.toString());
    }


    @Test
    void rankCount_초기화_테스트() {
        Map<Rank, Integer> rankCount = lottoResult.getRankCount();
        for (Rank rank : Rank.values()) {
            assertEquals(0, rankCount.get(rank));
        }
    }
}
