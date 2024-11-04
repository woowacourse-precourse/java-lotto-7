package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {
    List<Lotto> purchasedLottos;

    public PurchasedLottos() {
        this.purchasedLottos = new ArrayList<>();
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public void addLotto(Lotto lotto) {
        purchasedLottos.add(lotto);
    }

    public int getSize() {
        return purchasedLottos.size();
    }
}
