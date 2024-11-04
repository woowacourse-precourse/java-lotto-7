package lotto.model;

public enum Ranking {

  FIRST("6개 일치 (2,000,000,000원)", 6, 2000000000),
  SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 5, 30000000),
  THIRD("5개 일치 (1,500,000원)", 5, 1500000),
  FOURTH("4개 일치 (50,000원)", 4, 50000),
  FIFTH("3개 일치 (5,000원)", 3, 5000),
  NONE("낙첨", 0, 0);

  private final String message;
  private final int winCount;
  private final int winPrice;

  Ranking(String message, int winCount, int winPrice) {
    this.message = message;
    this.winCount = winCount;
    this.winPrice = winPrice;
  }

  public String getMessage() {
    return message;
  }

  public int getWinPrice() {
    return winPrice;
  }

  public static Ranking valueOf(int count, boolean matchBonus) {
    if (count == FIRST.winCount) {
      return FIRST;
    }
    if (count == SECOND.winCount && matchBonus) {
      return SECOND;
    }
    if (count == THIRD.winCount) {
      return THIRD;
    }
    if (count == FOURTH.winCount) {
      return FOURTH;
    }
    if (count == FIFTH.winCount) {
      return FIFTH;
    }
    if (count < FIFTH.winCount) {
      return NONE;
    }
    throw new IllegalArgumentException("[ERROR] 일치하는 등수가 없습니다.");
  }
}
