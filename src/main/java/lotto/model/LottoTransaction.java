package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTransaction {
  private int amount = 0;
  private List<Lotto> purchasedLottos = new ArrayList<>();

  public void setPurchasedLottos(List<Lotto> lottos) {
    this.purchasedLottos = lottos;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getAmount() {

    return this.amount;
  }

  public List<Lotto> getPurchasedLottos() {

    return this.purchasedLottos;
  }
}
