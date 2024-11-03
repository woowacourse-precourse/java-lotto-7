package lotto.validator;

import lotto.exception.LottoException;

import java.util.List;

public class LottoValidator {

  private static final int LOTTO_NUMBER_COUNT = 6;
  private static final int MIN_LOTTO_NUMBER = 1;
  private static final int MAX_LOTTO_NUMBER = 45;

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
