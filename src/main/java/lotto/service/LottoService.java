package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.util.LottoStatistics;

public class LottoService {

  public List<Lotto> lottoResults(long numberOfPurchases) {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < numberOfPurchases; i++) {
      lottos.add(new Lotto(numberLottery()));
    }
    return lottos;
  }

  List<Integer> numberLottery() {
    List<Integer> numbers = new ArrayList<>();
    numbers.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    Collections.sort(numbers);
    return numbers;
  }

  public Map<LottoPrize, Integer> calculatingWinningStatistics(List<Lotto> lottos,
      List<Integer> winningNumbers, int bonusNumber) {
    LottoStatistics statistics = new LottoStatistics(); // LottoStatistics 인스턴스 생성

    for (Lotto lotto : lottos) {
      int matchCount = countMatches(lotto.getNumbers(), winningNumbers);
      boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
      statistics.addResult(matchCount, hasBonus); // 통계에 결과 추가
    }

    return statistics.getStatistics();
  }

  int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
    int matchCount = 0;
    for (int number : lottoNumbers) {
      if (winningNumbers.contains(number)) {
        matchCount++;
      }
    }
    return matchCount;
  }
}
