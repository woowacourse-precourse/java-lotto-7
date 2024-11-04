package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {

  private LottoNumberValidator() {

  }

  public static void validateNumber(int number) {
    if (number < LottoConstants.MIN_LOTTO_NUMBER || number > LottoConstants.MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException(
          String.format(ErrorMessages.LOTTO_NUMBER_RANGE, LottoConstants.MIN_LOTTO_NUMBER,
              LottoConstants.MAX_LOTTO_NUMBER));
    }
  }

  public static void validateNumbers(List<Integer> numbers) {
    if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException(
          String.format(ErrorMessages.LOTTO_NUMBER_COUNT, LottoConstants.LOTTO_NUMBER_COUNT));
    }
    Set<Integer> uniqueNumbers = new HashSet<>(numbers);
    if (uniqueNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_DUPLICATE);
    }
    for (int number : numbers) {
      validateNumber(number);
    }
  }

}
