package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ErrorMessages;
import lotto.util.LottoConstants;

public class InputView {

  public String readPurchaseAmount() {
    System.out.println(LottoConstants.PROMPT_PURCHASE_AMOUNT);
    return readLine();
  }

  public String readWinningNumbers() {
    System.out.println(LottoConstants.PROMPT_WINNING_NUMBERS);
    return readLine();
  }

  public String readBonusNumber() {
    System.out.println(LottoConstants.PROMPT_BONUS_NUMBER);
    return readLine();
  }

  private String readLine() {
    String input = Console.readLine();
    if (input == null || input.trim().isEmpty()) {
      throw new IllegalArgumentException(ErrorMessages.INPUT_REQUIRED);
    }
    return input.trim();
  }
}
