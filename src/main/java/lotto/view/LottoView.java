package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {

  public int inputAmount() {
    System.out.println("구입 금액을 입력해 주세요:");
    return Integer.parseInt(Console.readLine());
  }
}
