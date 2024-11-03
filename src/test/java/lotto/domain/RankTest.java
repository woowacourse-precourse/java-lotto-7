package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RankTest {
    @Test
    @DisplayName("매치 카운트와 보너스 여부에 따라 Rank가 올바르게 반환되는지 확인")
    void matchLottoRank() {
        assertEquals(Rank.SIX, Rank.matchLotto(6, false));  // 6개 일치
        assertEquals(Rank.FIVE_AND_BONUS, Rank.matchLotto(5, true)); // 5개 일치 + 보너스
        assertEquals(Rank.FIVE, Rank.matchLotto(5, false)); // 5개 일치
        assertEquals(Rank.FOUR, Rank.matchLotto(4, false)); // 4개 일치
        assertEquals(Rank.THREE, Rank.matchLotto(3, false)); // 3개 일치
        assertEquals(Rank.NONE, Rank.matchLotto(2, false)); // 2개 이하 일치
    }

}