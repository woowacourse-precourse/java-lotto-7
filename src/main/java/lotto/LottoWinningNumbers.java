package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinningNumbers {

  private Lotto winningNumber;

  private int bonusNumber;

  private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
  private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

  public int[] inputWinningNumber() {
    System.out.println();
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
      throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
    }
    boolean isValidRange = Arrays.stream(winningNumber).allMatch(num -> num >= 1 && num <= 45);
    if (!isValidRange) {
      throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    return true;
  }

  private boolean validateBonusNumber(int bonusNumber) {
    if (bonusNumber >= 1 && bonusNumber <= 45) {
      return true;
    }
    throw new IllegalArgumentException("보너스 번호는 1부터 45 사이여야 합니다.");
  }

  public void assignWinningNumber() {
    try {
      int[] winningNumber = inputWinningNumber();
      validateWinningNumber(winningNumber);
      List<Integer> winningNum = Arrays.stream(winningNumber)
          .boxed()
          .toList();
      this.winningNumber = new Lotto(winningNum);
    } catch (IllegalArgumentException e) {
      System.out.print("[ERROR] ");
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
      System.out.print("[ERROR] ");
      System.out.println(e.getMessage());
      assignBonusNumber();
    }
  }

  public int[] getWinningNumber() {
    int[] intArray = this.winningNumber.getNumbers().stream()
        .mapToInt(Integer::intValue)
        .toArray();
    return intArray;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }

}
