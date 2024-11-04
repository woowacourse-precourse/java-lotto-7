package lotto.constants;

public enum LottoConstants {

  MIN_NUMBER(1),
  MAX_NUMBER(45),
  LOTTO_PRICE(1000),
  NUMBER_COUNT(6);

  private final int value;

  LottoConstants(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
