package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class LottoTransaction {
  private int amount = 0;
  private List<Lotto> purchasedLottos = new ArrayList<>();
  private final EnumMap<PrizeRank, Integer> rankCounts;

  public LottoTransaction() {
    this.rankCounts = new EnumMap<>(PrizeRank.class);
    for (PrizeRank count : PrizeRank.values()) {
      rankCounts.put(count, 0);
    }
  }

  public void setPurchasedLottos(List<Lotto> lottos) {
    this.purchasedLottos = lottos;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public void addMatchCount(PrizeRank prizeRank) {

    rankCounts.put(prizeRank, rankCounts.get(prizeRank) + 1);
  }

  public int getAmount() {

    return this.amount;
  }

  public List<Lotto> getPurchasedLottos() {

    return this.purchasedLottos;
  }

  public EnumMap<PrizeRank, Integer> getRankCounts() {

    return this.rankCounts;
  }
}
