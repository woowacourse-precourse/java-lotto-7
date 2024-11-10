package lotto.view;

import static lotto.domain.ExceptionType.NUMBER_FORMAT;
import static lotto.domain.ExceptionType.OUT_OF_RANGE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

  public Input(String enteredValue) throws NumberFormatException {
    // 10만원이 넘는 로또 구매는 도박입니다. 도박은 중독입니다
    // // 문자열이 포함된 값이 들어오는 경우 NumberFormatException
    boolean isNumber = enteredValue.matches("-?\\\\d+");
    if (!isNumber) {
      throw new NumberFormatException(NUMBER_FORMAT.getMessage());
    }
//    validate(enteredValue);
    this.enteredValue = enteredValue;
  }

  private static void validate(String enteredValue) {
    if (Integer.parseInt(enteredValue) > 100000) {
      throw new NumberFormatException(OUT_OF_RANGE_AMOUNT.getMessage());
    }
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
