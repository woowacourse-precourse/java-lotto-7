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


  PrizeRank(int count, int prize, boolean isBonusNumber, String rank) {
    this.count = count;
    this.prize = prize;
    this.isBounsNumber = isBonusNumber;
    this.rank = rank;
  }


}

