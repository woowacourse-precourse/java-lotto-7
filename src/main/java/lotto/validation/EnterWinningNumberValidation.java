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
      Lotto lotto = new Lotto(enterNumbers);
      checkNegativeNumber(lotto);
      checkNumberRange(lotto);
      checkNumberCount(lotto);
      checkDuplicateNumbers(lotto);
      return true;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  void checkNegativeNumber(Lotto lotto) {
    for (int number : lotto.getNumbers()) {
      if (number < 0) {
        throw new IllegalArgumentException("[ERROR] 음수가 들어올수 없습니다.");
      }
    }
  }

  void checkNumberRange(Lotto lotto) {
    for (int number : lotto.getNumbers()) {
      if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
        throw new IllegalArgumentException("[ERROR] 로또의 숫자범위는 1~45까지 입니다");
      }
    }
  }

  void checkNumberCount(Lotto lotto) {
    if (lotto.getNumbers().size() != LOTTO_NUMBERS_SIZE) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }
  }

  void checkDuplicateNumbers(Lotto lotto) {
    Set<Integer> uniqueNumbers = new HashSet<>(lotto.getNumbers());
    if (uniqueNumbers.size() != lotto.getNumbers().size()) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 중복해서 적을수 없습니다");
    }

  }


}
