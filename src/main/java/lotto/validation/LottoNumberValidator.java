package lotto.validation;

import java.util.HashSet;
import java.util.List;
import lotto.enums.ErrorMessage;

public class LottoNumberValidator {
  public static void mainValidator(List<Integer> lottoNumbers) {
    validateNumbers(lottoNumbers);
    validateDuplicate(lottoNumbers);
  }

  public static void validateNumbers(List<Integer> lottoNumbers) {
    if (lottoNumbers.size() != 6) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_QUANTITY.getMessage());
    }
    for (Integer number : lottoNumbers) {
      if (number <= 0 || number > 45) {
        throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
      }
    }
  }

  private static void validateDuplicate(List<Integer> lottoNumbers) {
    HashSet<Integer> uniqueNumbers = new HashSet<>();
    for (Integer number : lottoNumbers) {
      if (!uniqueNumbers.add(number)) {
        throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
      }
    }
  }
}
