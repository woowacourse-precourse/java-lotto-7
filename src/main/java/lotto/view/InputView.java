package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public String readPurchaseAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    return readLine();
  }

  public String readWinningNumbers() {
    System.out.println("당첨 번호를 입력해 주세요.");
    return readLine();
  }

  public String readBonusNumber() {
    System.out.println("보너스 번호를 입력해 주세요.");
    return readLine();
  }

  private String readLine() {
    String input = Console.readLine();
    if (input == null || input.trim().isEmpty()) {
      throw new IllegalArgumentException("[ERROR] 입력이 필요합니다.");
    }
    return input.trim();
  }
}
