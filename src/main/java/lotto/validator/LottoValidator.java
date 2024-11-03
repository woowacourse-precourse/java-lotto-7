package lotto.validator;

import java.util.List;

public class LottoValidator {

  private static final int LOTTO_NUMBER_COUNT = 6;
  private static final int MIN_LOTTO_NUMBER = 1;
  private static final int MAX_LOTTO_NUMBER = 45;

  private static final String ERROR_INVALID_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
  private static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
  private static final String ERROR_OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이여야 합니다.";

  public static void validateLottoNumbers(List<Integer> numbers) {
    if (numbers.size() != LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException(ERROR_INVALID_SIZE);
    }
    if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
    }
    if (numbers.stream().anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER)) {
      throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
    }
  }
}
