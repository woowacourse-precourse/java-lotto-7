package lotto.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 1.
 */
public class WinningLottoUserInput implements UserInput {
  List<Integer> numbers;

  private WinningLottoUserInput (List<Integer> numbers) {
    this.numbers = new ArrayList<>(numbers);
  }

  public static WinningLottoUserInput from (List<Integer> numbers) {
    return new WinningLottoUserInput(numbers);
  }

  public List<Integer> getNumbers() {
    return this.numbers;
  }
}
