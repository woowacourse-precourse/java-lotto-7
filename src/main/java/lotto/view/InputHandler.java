package lotto.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;

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
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount); // Validation inside domain class
        return purchaseAmount.getAmount();
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
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
        return new WinningNumber(numbers); // Validation inside domain class
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
        return new BonusNumber(number, winningNumber); // Validation inside domain class
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private List<Integer> parseNumbers(String input) {
    String[] tokens = input.split(",");
    List<Integer> numbers = new ArrayList<>();
    for (String token : tokens) {
      try {
        numbers.add(Integer.parseInt(token.trim()));
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
      }
    }
    return numbers;
  }

}
