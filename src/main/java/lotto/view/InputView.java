package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  private static final String MESSAGE_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요:";
  private static final String MESSAGE_WINNING_NUMBERS = "당첨 번호를 입력해 주세요 (예: 1,2,3,4,5,6):";
  private static final String MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요:";

  public static int getPurchaseAmount() {
    System.out.println(MESSAGE_PURCHASE_AMOUNT);
    return Integer.parseInt(Console.readLine().trim());
  }

  public static String getWinningNumbers() {
    System.out.println(MESSAGE_WINNING_NUMBERS);
    return Console.readLine().trim();
  }

  public static int getBonusNumber() {
    System.out.println(MESSAGE_BONUS_NUMBER);
    return Integer.parseInt(Console.readLine().trim());
  }
}
