package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;

public class EnterWinningNumberValidation {

  private final static int LOTTO_NUMBER_MIN = 1;
  private final static int LOTTO_NUMBER_MAX = 45;
  private final static int LOTTO_NUMBERS_SIZE = 6;

  public boolean validateEnterWinningNumber(List<Integer> enterNumbers) {
    try {
      checkNegativeNumber(enterNumbers);
      checkNumberRange(enterNumbers);
      checkNumberCount(enterNumbers);
      checkDuplicateNumbers(enterNumbers);
      return true;
    }catch (NumberFormatException e) {
      System.out.println("[ERROR] 번호는 1~45의 숫자여야 합니다.");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  void checkNegativeNumber(List<Integer> lottos) {
    for (int number : lottos) {
      if (number < 0) {
        throw new IllegalArgumentException("[ERROR] 음수가 들어올수 없습니다.");
      }
    }
  }

  void checkNumberRange(List<Integer> lottos) {
    for (int number : lottos) {
      if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
        throw new IllegalArgumentException("[ERROR] 로또의 숫자범위는 1~45까지 입니다");
      }
    }
  }

  void checkNumberCount(List<Integer> lottos) {
    if (lottos.size() != LOTTO_NUMBERS_SIZE) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }
  }

  void checkDuplicateNumbers(List<Integer> lottos) {
    Set<Integer> uniqueNumbers = new HashSet<>(lottos);
    if (uniqueNumbers.size() != lottos.size()) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 중복해서 적을수 없습니다");
    }
  }



}
