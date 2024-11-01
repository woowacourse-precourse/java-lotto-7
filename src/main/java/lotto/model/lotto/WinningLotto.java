package lotto.model.lotto;

import java.util.List;
import lotto.dto.WinningLottoUserInput;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 1.
 */
public class WinningLotto extends Lotto {

  private WinningLotto(List<Integer> numbers) {
    super(numbers);
  }

  public static WinningLotto from(WinningLottoUserInput userInput) {
    return new WinningLotto(userInput.getNumbers());
  }
}
