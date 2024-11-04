package lotto.view;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;
import lotto.util.ErrorMessages;

public class InputHandler {

  private final InputView inputView;

  public InputHandler(InputView inputView) {
    this.inputView = inputView;
  }

  public BigDecimal getPurchaseAmount() {
    while (true) {
      try {
        String input = inputView.readPurchaseAmount();
        BigDecimal amount = new BigDecimal(input);
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        return purchaseAmount.amount();
      } catch (NumberFormatException e) {
        System.out.printf((ErrorMessages.NUMBER_REQUIRED) + "%n", "구입 금액");
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public WinningNumber getWinningNumber() {
    while (true) {
      try {
        String input = inputView.readWinningNumbers();
        List<Integer> numbers = parseNumbers(input);
        return new WinningNumber(numbers);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public BonusNumber getBonusNumber(WinningNumber winningNumber) {
    while (true) {
      try {
        String input = inputView.readBonusNumber();
        int number = Integer.parseInt(input);
        return new BonusNumber(number, winningNumber);
      } catch (NumberFormatException e) {
        System.out.printf((ErrorMessages.NUMBER_REQUIRED) + "%n", "보너스 번호");
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private List<Integer> parseNumbers(String input) {
    try {
      return Arrays.stream(input.split(",")).map(String::trim).map(Integer::parseInt).toList();
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(String.format(ErrorMessages.NUMBER_REQUIRED, "당첨 번호"));
    }
  }
}
