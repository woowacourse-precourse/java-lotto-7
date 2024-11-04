package lotto.model.lotto;

import lotto.dto.BonusUserInput;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 1.
 */
public class Bonus {
  private int number;

  private Bonus (int number) {
    this.number = number;
  }

  public static Bonus from(BonusUserInput userInput) {
    return new Bonus(userInput.getNumber());
  }

  public int getNumber () {
    return this.number;
  }
}
