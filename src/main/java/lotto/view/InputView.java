package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView implements InputViewInterface {

  final static String PURCHASE_MESSAGE = "로또 구입 금액을 입력하세요";
  final static String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력하세요";
  final static String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력하세요";

  // 모든 메시지를 출력하는 공통 메서드
  private void printMessage(String message) {
    System.out.println(message);
  }

  public void printPurchaseMessage() {
    printMessage(PURCHASE_MESSAGE);
  }

  public void printWinningNumbersMessage() {
    printMessage(WINNING_NUMBERS_MESSAGE);
  }

  public void printBonusNumberMessage() {
    printMessage(BONUS_NUMBER_MESSAGE);
  }
  @Override
  public String readPurchaseAmount() {
    printPurchaseMessage();
    return Console.readLine();
  }

  @Override
  public String readWinningNumbers() {
    printWinningNumbersMessage();
    return Console.readLine();
  }

  @Override
  public String readBonusNumber() {
    printBonusNumberMessage();
    return Console.readLine();
  }
}
