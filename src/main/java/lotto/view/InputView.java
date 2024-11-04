package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView implements InputViewInterface {

  final static String PURCHASE_MESSAGE = "로또 구입 금액을 입력하세요";
  final static String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력하세요";
  final static String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력하세요";

  @Override
  public String readPurchaseAmount() {
    System.out.println(PURCHASE_MESSAGE);
    return Console.readLine();
  }

  @Override
  public String readWinningNumbers() {
    System.out.println(WINNING_NUMBERS_MESSAGE);
    return Console.readLine();
  }

  @Override
  public String readBonusNumber() {
    System.out.println(BONUS_NUMBER_MESSAGE);
    return Console.readLine();
  }
}
