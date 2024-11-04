package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

  public Input(String enteredValue) {
    this.enteredValue = enteredValue;
  }

  private String enteredValue;



  private final int LOTTO_PRICE = 1000;
  

  public int readAmount() {


    int amount = Integer.parseInt(enteredValue);
    return amount;
  }

  public int getLottoCounts(int amount) {
    return  amount / LOTTO_PRICE;
  }

  // 3. 그 다음 사용자가 당첨 번호를 입력하고
  public String readWinning() {
    String winning = Console.readLine();
    return winning;
  }

  //  4. 보너스 번호까지 입력하면
  public int readBonus() {
    String bonus = Console.readLine();
    int bonusNnumber = Integer.parseInt(bonus);
    return bonusNnumber;
  }
}
