package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Input {

  private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
  private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


  public int inputPurchaseAmount() {
    System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    int purchaseAmount = Integer.parseInt(Console.readLine());
    return purchaseAmount;
  }

  public int[] inputWinningNumber() {
    System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    int[] winningNumber = Arrays.stream(Console.readLine().split(","))
        .mapToInt(Integer::parseInt)
        .toArray();
    return winningNumber;
  }

  public int inputBonusNumber() {
    System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    int bonusNumber = Integer.parseInt(Console.readLine());
    return bonusNumber;
  }

}
