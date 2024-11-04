package lotto.validator;

import lotto.exception.LottoException;

import java.util.List;

public class LottoValidator {

  private static final int LOTTO_NUMBER_COUNT = 6;
  private static final int MIN_LOTTO_NUMBER = 1;
  private static final int MAX_LOTTO_NUMBER = 45;
  private static final int PURCHASE_UNIT = 1000;

  public static void validatePurchaseAmount(int amount) {
    if (amount <= 0 || amount % PURCHASE_UNIT != 0) {
      LottoException.throwInvalidPurchaseAmountException();
    }
  }

  public static void validateLottoNumbers(List<Integer> numbers) {
    if (numbers.size() != LOTTO_NUMBER_COUNT) {
      LottoException.throwInvalidSizeException();
    }
    if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
      LottoException.throwDuplicateNumberException();
    }
    if (numbers.stream().anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER)) {
      LottoException.throwOutOfRangeException();
    }
  }
}
