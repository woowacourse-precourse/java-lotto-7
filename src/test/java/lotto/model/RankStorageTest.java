package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankStorageTest {

    @Test
    @DisplayName("초기화된 RankStorage가 올바르게 생성되는지 테스트")
    void createRankStorage() {
        RankStorage rankStorage = new RankStorage();

        for (int rank = 1; rank <= 5; rank++) {
            assertEquals(0, rankStorage.getRankCount(rank));
        }
    }

    @Test
    @DisplayName("랭크 카운트 증가가 올바르게 작동하는지 테스트")
    void increaseRankCount() {
        RankStorage rankStorage = new RankStorage();
        int rankToIncrease = 3;

        rankStorage.increaseRankCount(rankToIncrease);

        assertEquals(1, rankStorage.getRankCount(rankToIncrease));
    }

    @Test
    @DisplayName("랭크 카운트를 여러 번 증가시키는 테스트")
    void increaseRankCount_Multiple() {
        RankStorage rankStorage = new RankStorage();
        int rankToIncrease = 5;

        rankStorage.increaseRankCount(rankToIncrease);
        rankStorage.increaseRankCount(rankToIncrease);
        rankStorage.increaseRankCount(rankToIncrease);

        assertEquals(3, rankStorage.getRankCount(rankToIncrease));
    }

    @Test
    @DisplayName("잘못된 랭크 카운트를 요청할 경우 예외 발생")
    void getRankCount_InvalidRank() {
        RankStorage rankStorage = new RankStorage();

        assertThrows(NullPointerException.class, () -> rankStorage.getRankCount(6));
    }
}
