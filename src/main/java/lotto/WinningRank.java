package lotto;

public enum WinningRank {
  NO_LUCK(0, 0, "저런! 운이 없었군요"),
  THREE_MATCH(1, 5000, "3개 일치 (5,000원)"),
  FOUR_MATCH(2, 50000, "4개 일치 (50,000원)"),
  FIVE_MATCH(3, 1500000, "5개 일치 (1,500,000원)"),
  FIVE_MATCH_BONUS(4, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
  SIX_MATCH(5, 2000000000, "6개 일치 (2,000,000,000원)");

  private final int rank;
  private final int prize;
  private final String description;

  WinningRank(int rank, int prize, String description) {
    this.rank = rank;
    this.prize = prize;
    this.description = description;
  }

  public int getPrize() {
    return prize;
  }

  public String getDescription() {
    return description;
  }
}