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

  // 3. 그 다음 사용자가 당첨 번호를 입력하고

  //  4. 보너스 번호까지 입력하면
}
