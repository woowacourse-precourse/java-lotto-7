package lotto.service;

public enum Prize {
  FIRST(2000000000), // 6개 일치
  SECOND(30000000),  // 5개 + 보너스 일치
  THIRD(1500000),    // 5개 일치
  FOURTH(50000),     // 4개 일치
  FIFTH(5000);       // 3개 일치

  private final int amount;

  Prize(int amount) {
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }
}
