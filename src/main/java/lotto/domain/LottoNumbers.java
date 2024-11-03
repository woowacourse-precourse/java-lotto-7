package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.validator.LottoValidator;

public class LottoNumbers {

  private final List<Integer> numbers;

  public LottoNumbers(List<Integer> numbers) {
    LottoValidator.validateLottoNumbers(numbers);
    this.numbers = List.copyOf(numbers);
  }

  public List<Integer> getNumbers() {
    return Collections.unmodifiableList(numbers);
  }

  public int countMatchingNumbers(LottoNumbers other) {
    return (int) numbers.stream()
        .filter(other.getNumbers()::contains)
        .count();
  }
}
