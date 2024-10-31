package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

  private final int LOTTO_PRICE = 1000;
  

  public int readAmount() {
    String enteredValue = Console.readLine();
    int amount = Integer.parseInt(enteredValue);
    return amount;
  }

  public int getLottoCounts(int amount) {
    return  amount / LOTTO_PRICE;
  }
}
