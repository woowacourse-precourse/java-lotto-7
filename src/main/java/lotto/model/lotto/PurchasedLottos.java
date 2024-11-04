package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class PurchasedLottos {
  List<Lotto> lottos;

  private PurchasedLottos (List<Lotto> lottos) {
    this.lottos = new ArrayList<>(lottos);
  }

  public static PurchasedLottos from (List<Lotto> lottos) {
    return new PurchasedLottos(lottos);
  }

  public List<Lotto> getLottos() {
    return lottos;
  }
}
