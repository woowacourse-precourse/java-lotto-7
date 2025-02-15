package lotto;

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
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
    Set<Integer> uniqueNumbers = new HashSet<>(numbers);
    if (uniqueNumbers.size() != numbers.size()) {
      throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
    }
  }


  // TODO: 추가 기능 구현
  public void lottoToString() {
    System.out.println(this.numbers.toString());
  }

  public int countMatchingNumbers(int[] winningNumbers) {
    Set<Integer> lottoNumbersSet = new HashSet<>(this.numbers);
    int matchCount = 0;
    for (int winningNumber : winningNumbers) {
      if (lottoNumbersSet.contains(winningNumber)) {
        matchCount++;
      }
    }
    return matchCount;
  }

  public boolean matchBonusNumber(int bonusNumber) {
    Set<Integer> lottoNumberSet = new HashSet<>(this.numbers);
    if (lottoNumberSet.contains(bonusNumber)) {
      return true;
    }
    return false;
  }

  public List<Integer> getNumbers()
  {
    return this.numbers;
  }
}
