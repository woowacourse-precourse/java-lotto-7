package lotto.domain;

public enum Message {
  FIRST("6개 일치 (2,000,000,000원) - 0"),
  SECOND("4개 일치 (50,000원) - 0"),
  THIRD("5개 일치 (1,500,000원) - 0개"),
  FOURTH("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개"),
  FIFTH("3개 일치 (5,000원) - 1개\n");

  Message(String message) {
    this.message = message;
  }

  private String message;

  public String getMessage() {
    return message;
  }

}
