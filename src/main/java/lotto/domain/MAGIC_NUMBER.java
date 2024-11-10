package lotto.domain;

public enum MAGIC_NUMBER {
  START(0), SIZE(6);

  MAGIC_NUMBER(int magicNumber) {
    this.magicNumber = magicNumber;
  }

  private int magicNumber;

  public int getMagicNumber() {
    return magicNumber;
  }
}
