package lotto.model;

public enum PrizeRank {
  FIRST(6, 2000000000, false, "1등"),
  SECOND(5, 30000000, true, "2등"), // 보너스 숫저 일치
  THIRD(5, 1500000, false, "3등"),
  FOURTH(4, 50000, false, "4등"),
  FIFTH(3, 5000, false, "5등"),
  LOSE(0, 0, false, "꽝");

  private final int count;
  private final int prize;
  private final boolean isBounsNumber;
  private final String rank;
  static final PrizeRank[] RANK_LOOKUP = {PrizeRank.LOSE, PrizeRank.LOSE, PrizeRank.LOSE, PrizeRank.FIFTH,
          PrizeRank.FOURTH,
          PrizeRank.THIRD, PrizeRank.FIRST, PrizeRank.SECOND};


  PrizeRank(int count, int prize, boolean isBonusNumber, String rank) {
    this.count = count;
    this.prize = prize;
    this.isBounsNumber = isBonusNumber;
    this.rank = rank;
  }


  static public PrizeRank getPrizeRank(int count, boolean isBounsNumber) {
    if (count == PrizeRank.SECOND.getCount() && isBounsNumber) {
      return RANK_LOOKUP[7];
    }
    return RANK_LOOKUP[count];
  }

  public int getCount() {
    return count;
  }

  public int getPrize() {
    return prize;
  }

  public String getRank() {
    return rank;
  }
}

