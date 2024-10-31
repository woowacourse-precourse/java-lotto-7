package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

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
  public List<Integer> readWinning() {
    String winning = Console.readLine();
    List<Integer> winningNumbers = new ArrayList<>();
    // 당천 번호 입력 문자열을 읽으면
    for (int i = 0; i < winning.length(); i++) {
      // 쉼표와 공백 구분자를 제외하고 각 정수를 하나씩 리스트에 추가한다
//      winningNumbers.add(index);
    }
    return winningNumbers;
  }

  //  4. 보너스 번호까지 입력하면
  public int readBonus() {
    String bonus = Console.readLine();
    int bonusNnumber = Integer.parseInt(bonus);
    return bonusNnumber;
  }
}
