package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public List<Integer> readWinningNumbers() {
    while (true) {
      try {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winningNumbers = validateWinningNumbers(input);
        return winningNumbers;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private List<Integer> validateWinningNumbers(String input) {
    if (input == null || input.trim().isEmpty()) {
      throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    String[] tokens = input.split(",");
    if (tokens.length != 6) {
      throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    Set<Integer> numberSet = new HashSet<>();
    List<Integer> winningNumbers = new ArrayList<>();

    for (String token : tokens) {
      String trimmedToken = token.trim();

      int number;
      try {
        number = Integer.parseInt(trimmedToken);
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
      }

      if (number < 1 || number > 45) {
        throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
      }

      if (!numberSet.add(number)) {
        throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호가 있습니다.");
      }

      winningNumbers.add(number);
    }

    return winningNumbers;
  }

  public int readBonusNumber(List<Integer> winningNumbers) {
    while (true) {
      try {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNumber = validateBonusNumber(input, winningNumbers);
        return bonusNumber;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private int validateBonusNumber(String input, List<Integer> winningNumbers) {
    if (input == null || input.trim().isEmpty()) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해야 합니다.");
    }

    String trimmedInput = input.trim();

    int bonusNumber;
    try {
      bonusNumber = Integer.parseInt(trimmedInput);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
    }

    if (bonusNumber < 1 || bonusNumber > 45) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    if (winningNumbers.contains(bonusNumber)) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    return bonusNumber;
  }

}
