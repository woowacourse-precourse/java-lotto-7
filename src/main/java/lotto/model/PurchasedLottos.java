package lotto.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PurchasedLottos implements Iterable<Lotto> {
    List<Lotto> lottos;

    public PurchasedLottos() {
        lottos = new ArrayList<>();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getSize() {
        return lottos.size();
    }
}
