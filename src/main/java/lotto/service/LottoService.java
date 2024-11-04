package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
  // 사용자가 구매한 로또 생성
  public List<Lotto> generateUserLottos(int amount) {
    int count = amount / 1000; // 1,000원당 로또 한 장
    List<Lotto> userLottos = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      userLottos.add(new Lotto());
    }
    return userLottos;
  }

  // 당첨 번호와 보너스 번호를 생성
  public Lotto drawWinningLotto() {
    return new Lotto();  // 당첨 번호 생성
  }

  // 당첨 내역 계산 (간단하게 구현)
  public void checkWinningNumbers(List<Lotto> userLottos, Lotto winningLotto) {
    for (Lotto lotto : userLottos) {
      int matchCount = calculateMatch(lotto.getNumbers(), winningLotto.getNumbers());
      System.out.println(matchCount + "개 번호 일치");
    }
  }

  // 일치하는 번호 개수 계산
  private int calculateMatch(List<Integer> userNumbers, List<Integer> winningNumbers) {
    int matchCount = 0;
    for (int number : userNumbers) {
      if (winningNumbers.contains(number)) {
        matchCount++;
      }
    }
    return matchCount;
  }
}
