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
    void 랭크_카운트_초기화() {
        Map<Rank, Long> rankCount = lottoResult.getRankCount();
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
    void 총상금계산_없는경우_테스트() {
        assertEquals(0, lottoResult.calculateTotalPrizeMoney());
    }
}
