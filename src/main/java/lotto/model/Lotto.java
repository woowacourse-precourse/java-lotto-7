package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    // TODO 다른 validate가 모여서 사용되는 함수로 구성 할 것

    final int NUMBERS_LENGTH = 6;
    Set<Integer> uniqueNumbers = new HashSet<>(numbers);

    if (numbers.size() != NUMBERS_LENGTH) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    if (uniqueNumbers.size() < NUMBERS_LENGTH) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }
  }
  // TODO: 추가 기능 구현
  // TODO 로또 생성에 대한 validate 추가 예정
}
