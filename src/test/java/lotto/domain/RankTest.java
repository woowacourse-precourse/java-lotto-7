package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    // Todo : domain - service - validator - repository - controller
    // Todo : AppConfig, constant, exception 테스트 불필요
    @Test
    @DisplayName("각 Rank에 해당하는 matchCount와 isBonusMathch를 입력하면 해당 Rank를 반환한다.")
    void RankValueOfTest() {
        assertEquals(Rank.FIRST, Rank.valueOf(6, false));
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
        assertEquals(Rank.THIRD, Rank.valueOf(5, false));
        assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
        assertEquals(Rank.NONE, Rank.valueOf(0, false));
    }

    @Test
    @DisplayName("각 Rank에 해당하는 상금을 반환한다.")
    void getPrizeTest() {
        assertEquals(2_000_000_000, Rank.FIRST.getPrize());
        assertEquals(30_000_000, Rank.SECOND.getPrize());
        assertEquals(1_500_000, Rank.THIRD.getPrize());
        assertEquals(50_000, Rank.FOURTH.getPrize());
        assertEquals(5_000, Rank.FIFTH.getPrize());
        assertEquals(0, Rank.NONE.getPrize());
    }

    @Test
    @DisplayName("각 Rank에 해당하는 상금을 포맷팅하여 반환한다.")
    void getFormattedPrizeTest() {
        assertEquals(" (2,000,000,000원)", Rank.FIRST.getFormattedPrize());
        assertEquals(" (30,000,000원)", Rank.SECOND.getFormattedPrize());
        assertEquals(" (1,500,000원)", Rank.THIRD.getFormattedPrize());
        assertEquals(" (50,000원)", Rank.FOURTH.getFormattedPrize());
        assertEquals(" (5,000원)", Rank.FIFTH.getFormattedPrize());
        assertEquals(" (0원)", Rank.NONE.getFormattedPrize());
    }

    @Test
    @DisplayName("각 Rank에 해당하는 메시지를 반환한다.")
    void getMessage() {
        assertEquals("6개 일치", Rank.FIRST.getMessage());
        assertEquals("5개 일치, 보너스 볼 일치", Rank.SECOND.getMessage());
        assertEquals("5개 일치", Rank.THIRD.getMessage());
        assertEquals("4개 일치", Rank.FOURTH.getMessage());
        assertEquals("3개 일치", Rank.FIFTH.getMessage());
        assertEquals("0개 일치", Rank.NONE.getMessage());
    }

    @Test
    @DisplayName("Rank에 해당하는 matchCount와 isBonusMathch가 일치 하는지 확인한다.")
    void RankValueOfMatchCountAndIsBonusMatchTest() {
        assertEquals(Rank.FIRST, Rank.valueOf(6, false));
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
        assertEquals(Rank.THIRD, Rank.valueOf(5, false));
        assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
        assertEquals(Rank.NONE, Rank.valueOf(0, false));
    }
}