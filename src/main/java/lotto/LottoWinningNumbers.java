package lotto;
import java.util.Arrays;

public class LottoWinningNumbers {

  private int[] winningNumber;

  private int bonusNumber;

  private boolean validateWinningNumber(int[] winningNumber) {
    if (winningNumber.length != 6) {
      throw new IllegalArgumentException("[ERROR] 당첨 번호가 6자리가 아니면 안됨");
    }
    boolean isValid = Arrays.stream(winningNumber).allMatch(num -> num >= 1 && num <= 45);
    if (!isValid) {
      throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자여야 한다.");
    }
    return isValid;
  }


  private boolean validateBonusNumber(int bonusNumber) {
    if (bonusNumber >= 1 && bonusNumber <= 45) {
      return true;
    }
    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이");
  }

  public void assignWinningNumber(int[] winningNumber) {
    validateWinningNumber(winningNumber);
    this.winningNumber = winningNumber;
  }

  public void assignBonusNumber(int bonusNumber) {
    validateBonusNumber(bonusNumber);
    this.bonusNumber = bonusNumber;
  }
}
