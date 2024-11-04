package lotto.validation;

import java.util.ArrayList;
import java.util.List;

public class EnterBonusNumberValidation extends EnterWinningNumberValidation {
  private final static int LOTTO_NUMBER_MIN = 1;
  private final static int LOTTO_NUMBER_MAX = 45;
  private final static int LOTTO_NUMBERS_SIZE = 6;
  public boolean validateEnterBonusNumber(List<Integer> winningNumbers,String bonusNumber) {
    try {
      List<Integer> winningNumbersAddBonusNumber=new ArrayList<>(winningNumbers);
      int bonusNumberToInt=Integer.parseInt(bonusNumber);
      winningNumbersAddBonusNumber.add(bonusNumberToInt);
      checkNegativeNumber(bonusNumberToInt);
      checkNumberRange(bonusNumberToInt);
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
  void checkNegativeNumber(int bonusNumber){
    if(bonusNumber<0){
      throw new IllegalArgumentException("[ERROR] 음수가 들어올수 없습니다.");
    }
  }
  void checkNumberRange(int bonusNumber) {
    if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
      throw new IllegalArgumentException("[ERROR] 로또의 숫자범위는 1~45까지 입니다");
    }
  }
}
