package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResultCalculator {

  private int getLottoRankNumber(Lotto winningLotto, Lotto userLotto) {
    return (int) userLotto.getNumbers().stream()
            .filter(winningLotto::containsWinningNumber)
            .count();
  }

  public Ranking getLottoRanking(Lotto winningLotto, Lotto userLotto, int bonusNumbers) {
    int matchCount = getLottoRankNumber(winningLotto, userLotto);
    boolean matchBonus = userLotto.containsWinningNumber(bonusNumbers);
    return Ranking.valueOf(matchCount, matchBonus);
  }

  public double calculateTotalEarningRate(int totalPurchaseAmount, int totalWinningAmount) {
    return Math.round((double) totalWinningAmount / totalPurchaseAmount * 10000) / 100.0;
  }

  public Map<Ranking, Integer> getResultStorage(Lotto winningLotto, Lottos lottos, int bonusNumber) {
    Map<Ranking, Integer> resultStorage = setResultStorage();
    lottos.lottos().stream()
            .map(lotto -> getLottoRanking(winningLotto, lotto, bonusNumber))
            .forEach(rank -> resultStorage.put(rank, resultStorage.get(rank) + 1));
    return resultStorage;
  }

  private Map<Ranking, Integer> setResultStorage() {
    Map<Ranking, Integer> returningMap = new LinkedHashMap<>();
    for (Ranking ranking : Ranking.values()) {
      returningMap.put(ranking, 0);
    }
    return returningMap;
  }
}