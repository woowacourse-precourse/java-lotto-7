package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

  private static final int DEFAULT_LOTTO_NUMBER_SIZE = 6;
  private static final int MIN_LOTTO_NUMBER = 1;
  private static final int MAX_LOTTO_NUMBER = 45;
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validateNumberSize(numbers);
    validateDuplicatedNumbers(numbers);
    validateNumberRange(numbers);
    this.numbers = numbers;
  }

  public Lotto(List<Integer> numbers, int bonus) {
    validateNumberSize(numbers);
    validateDuplicateWinningNumbers(numbers);
    validateNumberRange(numbers);
    this.numbers = numbers;
    validateDuplicateBonus(numbers, bonus);
    validateBonusRange(bonus);
  }

  private void validateNumberSize(List<Integer> numbers) {
    if (numbers.size() != DEFAULT_LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }
  }

  private void validateDuplicatedNumbers(List<Integer> numbers) throws IllegalArgumentException {
    Set<Integer> uniqueNumbers = new HashSet<>(numbers);
    if (uniqueNumbers.size() != numbers.size()) {
      throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
    }
  }

  private void validateNumberRange(List<Integer> numbers) {
    if (numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
    }
  }

  private void validateDuplicateWinningNumbers(List<Integer> winningNumbers) {
    Set<Integer> winningNumberSet = new HashSet<>(winningNumbers);
    if (winningNumberSet.size() != winningNumbers.size()) {
      throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
    }
  }

  private void validateDuplicateBonus(List<Integer> numbers, int bonus) {
    if (numbers.contains(bonus)) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
  }

  private void validateBonusRange(int bonus) {
    if (bonus < MIN_LOTTO_NUMBER || bonus > MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
    }
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public boolean containsWinningNumber(int number) {
    return numbers.contains(number);
  }
}
