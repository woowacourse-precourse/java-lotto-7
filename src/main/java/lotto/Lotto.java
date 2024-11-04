package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  private void validate(List<Integer> numbers) {
    HashSet<Integer> set = new HashSet<>(numbers);
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    if (numbers.stream().anyMatch(n -> n > 45 || n < 1)) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    if (set.size() != 6) {
      throw new IllegalArgumentException("[ERROR] 중복된 숫자가 선택되었습니다.");
    }
  }

  @Override
  public String toString() {
    return numbers.toString();
  }
}