package lotto.model;

import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  public List<Integer> getNumbers() {

    return this.numbers;
  }

  private void validate(List<Integer> numbers) {
    LottoValidator.validate(numbers);
  }
}
