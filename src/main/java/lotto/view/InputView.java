package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;

public class InputView {

  public BigDecimal readPurchaseAmount() {
    while (true) {
      try {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        BigDecimal amount = validatePurchaseAmount(input);
        return amount;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private BigDecimal validatePurchaseAmount(String input) {
    BigDecimal amount;

    try {
      amount = new BigDecimal(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
    }

    if (amount.compareTo(BigDecimal.valueOf(1000)) < 0) {
      throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
    }

    if (amount.remainder(BigDecimal.valueOf(1000)).compareTo(BigDecimal.ZERO) != 0) {
      throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    return amount;
  }
}
