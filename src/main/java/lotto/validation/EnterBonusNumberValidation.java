package lotto.validation;

import java.util.ArrayList;
import java.util.List;

public class EnterBonusNumberValidation extends EnterWinningNumberValidation {

  public boolean validateEnterBonusNumber(List<Integer> winningNumbers,String bonusNumber) {
    try {
      List<Integer> winningNumbersAddBonusNumber=new ArrayList<>(winningNumbers);
      int bonusNumberToInt=Integer.parseInt(bonusNumber);
      winningNumbersAddBonusNumber.add(bonusNumberToInt);

      checkNegativeNumber(winningNumbersAddBonusNumber);
      checkNumberRange(winningNumbersAddBonusNumber);
      checkDuplicateNumbers(winningNumbersAddBonusNumber);
      return true;
    } catch (NumberFormatException e) {
      System.out.println("[ERROR] 보너스 번호는 1~45의 숫자여야 합니다.");
      return false;
    }catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
}
