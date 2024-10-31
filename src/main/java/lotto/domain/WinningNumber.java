package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
  private static final int REQUIRED_NUMBER_COUNT = 6;
  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;

  private final Set<Integer> numbers;

  public WinningNumber(List<Integer> numbers) {
    validate(numbers);
    this.numbers = new HashSet<>(numbers);
  }

  private void validate(List<Integer> numbers) {
    if (numbers.size() != REQUIRED_NUMBER_COUNT) {
      throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
    }
    Set<Integer> numberSet = new HashSet<>(numbers);
    if (numberSet.size() != REQUIRED_NUMBER_COUNT) {
      throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
    }
    for (int number : numbers) {
      if (number < MIN_NUMBER || number > MAX_NUMBER) {
        throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
      }
    }
  }

  public boolean contains(int number) {
    return numbers.contains(number);
  }

  public Set<Integer> getNumbers() {
    return new HashSet<>(numbers);
  }
}
