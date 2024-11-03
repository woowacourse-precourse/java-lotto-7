package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoQuickPick {
  MoneyInputHandler moneyInputHandler = new MoneyInputHandler();

  public List<Lotto> quickPick() {
    List<Lotto> randomPicks = new ArrayList<>();
    int amount = moneyInputHandler.getMoney() / 1000;
    for (int i = 0; i < amount; i++) {
      List<Integer> randomNumbers = randomNumberSelect();
      Lotto lotto = new Lotto(randomNumbers);
      randomPicks.add(lotto);
    }
    messagePrint(randomPicks, amount);
    return randomPicks;
  }

  private List<Integer> randomNumberSelect() {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
        .stream()
        .sorted()
        .toList();
  }

  private void messagePrint(List<Lotto> randomPicks, int amount) {
    System.out.printf("\n%d개를 구매했습니다.\n", amount);
    for (Lotto lotto : randomPicks) {
      System.out.println(lotto);
    }
    System.out.println();
  }
}