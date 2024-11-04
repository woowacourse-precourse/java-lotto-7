package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {
    private final List<Lotto> lottos;

    public PurchasedLottos() {
        lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
