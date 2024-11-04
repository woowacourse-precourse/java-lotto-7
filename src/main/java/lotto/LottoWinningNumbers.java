package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class LottoWinningNumbers {

  private int[] winningNumber;

  private int bonusNumber;

  private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
  private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

  public int[] inputWinningNumber() {
    System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    int[] winningNumber = Arrays.stream(Console.readLine().split(","))
        .mapToInt(Integer::parseInt)
        .toArray();
    System.out.println();
    return winningNumber;
  }

  public int inputBonusNumber() {
    System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    int bonusNumber = Integer.parseInt(Console.readLine());
    System.out.println();
    return bonusNumber;
  }

  private boolean validateWinningNumber(int[] winningNumber) {
    if (winningNumber.length != 6) {
      throw new IllegalArgumentException("[ERROR] 당첨 번호가 6자리가 아니면 안됩니다.");
    }
    boolean isValid = Arrays.stream(winningNumber).allMatch(num -> num >= 1 && num <= 45);
    if (!isValid) {
      throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자여야 합니다.");
    }
    return isValid;
  }

  private boolean validateBonusNumber(int bonusNumber) {
    if (bonusNumber >= 1 && bonusNumber <= 45) {
      return true;
    }
    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
  }

  public void assignWinningNumber() {
    try {
      int[] winningNumber = inputWinningNumber();
      validateWinningNumber(winningNumber);
      this.winningNumber = winningNumber;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      assignWinningNumber();
    }

  }

  public void assignBonusNumber() {
    try {
      int bonusNumber = inputBonusNumber();
      validateBonusNumber(bonusNumber);
      this.bonusNumber = bonusNumber;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      assignBonusNumber();
    }
  }

  public int[] getWinningNumber() {
    return winningNumber;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }

}
