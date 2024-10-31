package lotto.domain;

public class BonusNumber {

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;

  private final int number;

  public BonusNumber(int number, WinningNumber winningNumber) {
    validate(number, winningNumber);
    this.number = number;
  }

  private void validate(int number, WinningNumber winningNumber) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    if (winningNumber.contains(number)) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
  }

  public int getNumber() {
    return number;
  }
}
