package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 정적(static) 클래스, 인스턴스화 불가능 유용성 검사를 위해서만 사용됨
 */
public class LottoValidator {
  static public final int NUMBERS_LENGTH = 6;


  static final String ERROR_INVALID_LENGTH = "[ERROR] 로또 번호는 6개여야 합니다.";
  static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다.";


  /**
   * 정적(static) 클래스 인스턴스화 불가능 유용성 검사를 위해서만 사용됨
   */
  private LottoValidator() {
    // 인스턴스화 방지를 위해서 사용
  }

  static public void validate(List<Integer> numbers) {

    checkLength(numbers);
    checkDuplicates(numbers);
  }

  static void checkLength(List<Integer> numbers) {

    if (numbers.size() != NUMBERS_LENGTH) {
      throw new IllegalArgumentException(ERROR_INVALID_LENGTH);
    }
  }

  static void checkDuplicates(List<Integer> numbers) {
    Set<Integer> uniqueNumbers = new HashSet<>(numbers);

    if (uniqueNumbers.size() < NUMBERS_LENGTH) {
      throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
    }
  }

}
