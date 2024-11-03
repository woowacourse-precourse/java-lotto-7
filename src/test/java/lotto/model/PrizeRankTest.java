package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrizeRankTest {
  @Test
  public void 정상작동_확인() {
    // Test FIRST prize rank attributes
    PrizeRank first = PrizeRank.FIRST;
    assertEquals(6, first.getCount());
    assertEquals(2000000000, first.getPrize());
    assertEquals("1등", first.getRank());

    // Test SECOND prize rank attributes
    PrizeRank second = PrizeRank.SECOND;
    assertEquals(5, second.getCount());
    assertEquals(30000000, second.getPrize());
    assertEquals("2등", second.getRank());

    // Test other prize ranks as needed
  }

  @Test
  public void 테스트_getPrizeRank() {
    PrizeRank rank = PrizeRank.getPrizeRank(6, false);
    assertEquals(PrizeRank.FIRST, rank);
    rank = PrizeRank.getPrizeRank(5, true);
    assertEquals(PrizeRank.SECOND, rank);
    rank = PrizeRank.getPrizeRank(5, false);
    assertEquals(PrizeRank.THIRD, rank);
    rank = PrizeRank.getPrizeRank(4, false);
    assertEquals(PrizeRank.FOURTH, rank);
    rank = PrizeRank.getPrizeRank(3, false);
    assertEquals(PrizeRank.FIFTH, rank);

    rank = PrizeRank.getPrizeRank(0, false);
    assertEquals(PrizeRank.LOSE, rank);
  }
}