package lotto.dto;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 1.
 */
public class BonusUserInput implements UserInput {
  private final int number;

  private BonusUserInput(int number) {
    this.number = number;
  }

  public static BonusUserInput from(int input) {
    return new BonusUserInput(input);
  }

  public int getNumber() {
    return this.number;
  }

}
