package lotto.model.lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.common.exception.ExceptionEnum;
import lotto.view.exception.InputException;

public class Lotto {
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    validateDistinct(numbers);
    this.numbers = numbers;
  }

  public static Lotto from(List<Integer> numbers) {
      return new Lotto(sortNumbers(numbers));
  }

  private static List<Integer> sortNumbers(List<Integer> numbers) {
      return numbers.stream()
          .sorted()
          .collect(Collectors.toList());
  }

  private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
  }

  /**
   * 제공된 로또 번호 리스트의 유효성을 검사합니다.
   * 이 메서드는 `LottoTest`를 통과하기 위한 목적으로 구현되었습니다.
   * 실제 Lotto의 전체적인 유효성 검증은 LottoCommand에서 수행됩니다.
   *
   * @param numbers 검증할 로또 번호 리스트
   * @throws InputException 중복된 번호가 존재할 경우 발생
   */
  private void validateDistinct(List<Integer> numbers) {
    if (getDistinctCount(numbers) != numbers.size()) {
      throw new InputException(ExceptionEnum.IVALID_INPUT);
    }
  }

  /**
   * 주어진 로또 번호 리스트에서 중복을 제거한 후의 개수를 반환합니다.
   *
   * @param numbers 중복 검사할 로또 번호 리스트
   * @return 중복이 제거된 번호의 개수
   */
  private long getDistinctCount(List<Integer> numbers) {
    return numbers.stream()
        .distinct()
        .count();
  }

  public List<Integer> getNumbers () {
    return this.numbers;
  }
    // TODO: 추가 기능 구현
}
