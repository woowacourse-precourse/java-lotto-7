package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.LottoNumberValidator;

public class WinningNumber {

  private final Set<Integer> numbers;

  public WinningNumber(List<Integer> numbers) {
    LottoNumberValidator.validateNumbers(numbers);
    this.numbers = new HashSet<>(numbers);
  }

  public boolean contains(int number) {
    return numbers.contains(number);
  }

  public Set<Integer> getNumbers() {
    return new HashSet<>(numbers);
  }
}
