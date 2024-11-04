package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.model.Rank;
import org.junit.jupiter.api.Test;

public class LottoRankTest {
    @Test
    void 일치_개수와_보너스가_정확히_맞는_경우_올바른_Rank를_반환해야_한다() {
        assertEquals(Rank.FIRST, Rank.getRank(6, false));  // 6개 일치, 보너스 불필요
        assertEquals(Rank.SECOND, Rank.getRank(5, true));    // 5개 일치, 보너스 있음);  // 5개 일치, 보너스 필요
        assertEquals(Rank.THIRD, Rank.getRank(5, false));  // 5개 일치, 보너스 불필요
        assertEquals(Rank.FOURTH, Rank.getRank(4, false)); // 4개 일치
        assertEquals(Rank.FIFTH, Rank.getRank(3, false));  // 3개 일치
        assertEquals(Rank.MISS, Rank.getRank(2, false));   // 2개 이하 일치
    }

    @Test
    void 각_Rank가_정확한_상금을_반환해야_한다() {
        assertEquals(2_000_000_000, Rank.FIRST.getPrize());
        assertEquals(30_000_000, Rank.SECOND.getPrize());
        assertEquals(1_500_000, Rank.THIRD.getPrize());
        assertEquals(50_000, Rank.FOURTH.getPrize());
        assertEquals(5_000, Rank.FIFTH.getPrize());
        assertEquals(0, Rank.MISS.getPrize());
    }

}

