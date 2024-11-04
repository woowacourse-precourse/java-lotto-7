package lotto.domain;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LottoRankTest {

    @Test
    @DisplayName("매칭 카운트와 보너스 일치 여부에 따라 올바른 등수를 반환하는지 확인")
    public void testValueOf() {
        assertEquals("FIRST", LottoRank.valueOf(6, false), "6개 일치시 FIRST 등수여야 합니다.");
        assertEquals("SECOND", LottoRank.valueOf(5, true), "5개 일치 + 보너스 일치시 SECOND 등수여야 합니다.");
        assertEquals("THIRD", LottoRank.valueOf(5, false), "5개 일치시 THIRD 등수여야 합니다.");
        assertEquals("FOURTH", LottoRank.valueOf(4, false), "4개 일치시 FOURTH 등수여야 합니다.");
        assertEquals("FIFTH", LottoRank.valueOf(3, false), "3개 일치시 FIFTH 등수여야 합니다.");
        assertEquals("NONE", LottoRank.valueOf(2, false), "2개 이하 일치시 NONE 등수여야 합니다.");
    }

    @Test
    @DisplayName("매칭 카운트와 보너스 일치 여부에 따라 올바른 등수를 반환하는지 확인")
    public void testValueOfWhenTHIRDBonusNumberIsFALSE() {
        assertEquals("FIRST", LottoRank.valueOf(6, true), "6개 일치시 FIRST 등수여야 합니다.");
        assertEquals("SECOND", LottoRank.valueOf(5, true), "5개 일치 + 보너스 일치시 SECOND 등수여야 합니다.");
        assertEquals("THIRD", LottoRank.valueOf(5, false), "5개 일치시 THIRD 등수여야 합니다.");
        assertEquals("FOURTH", LottoRank.valueOf(4, true), "4개 일치시 FOURTH 등수여야 합니다.");
        assertEquals("FIFTH", LottoRank.valueOf(3, true), "3개 일치시 FIFTH 등수여야 합니다.");
        assertEquals("NONE", LottoRank.valueOf(2, true), "2개 이하 일치시 NONE 등수여야 합니다.");
    }

    @Test
    @DisplayName("LottoRankCollector가 각 등수를 0으로 초기화하는지 확인")
    public void testLottoRankCollector() {
        Map<String, Integer> rankCounts = LottoRank.LottoRankCollector();

        assertEquals(5, rankCounts.size(), "LottoRankCollector는 5개의 등수를 포함해야 합니다.");
        assertEquals(0, rankCounts.get("FIRST"), "FIRST 등수는 초기값으로 0이어야 합니다.");
        assertEquals(0, rankCounts.get("SECOND"), "SECOND 등수는 초기값으로 0이어야 합니다.");
        assertEquals(0, rankCounts.get("THIRD"), "THIRD 등수는 초기값으로 0이어야 합니다.");
        assertEquals(0, rankCounts.get("FOURTH"), "FOURTH 등수는 초기값으로 0이어야 합니다.");
        assertEquals(0, rankCounts.get("FIFTH"), "FIFTH 등수는 초기값으로 0이어야 합니다.");
    }

    @Test
    @DisplayName("각 등수의 상금이 올바르게 반환되는지 확인")
    public void testGetPrize() {
        assertEquals(2000000000, LottoRank.FIRST.getPrize(), "FIRST 등수의 상금은 2000000000이어야 합니다.");
        assertEquals(30000000, LottoRank.SECOND.getPrize(), "SECOND 등수의 상금은 30000000이어야 합니다.");
        assertEquals(1500000, LottoRank.THIRD.getPrize(), "THIRD 등수의 상금은 1500000이어야 합니다.");
        assertEquals(50000, LottoRank.FOURTH.getPrize(), "FOURTH 등수의 상금은 50000이어야 합니다.");
        assertEquals(5000, LottoRank.FIFTH.getPrize(), "FIFTH 등수의 상금은 5000이어야 합니다.");
    }
}
