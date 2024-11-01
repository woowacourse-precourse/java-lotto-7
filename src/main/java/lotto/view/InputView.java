package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView implements InputViewInterface {

  @Override
  public String readPurchaseAmount() {
    return Console.readLine();
  }

  @Override
  public String readWinningNumbers() {
    return Console.readLine();
  }

  @Override
  public String readBonusNumber() {
    return Console.readLine();
  }
}
