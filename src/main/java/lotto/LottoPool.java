package lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LottoPool implements Iterable<Lotto> {

    private List<Lotto> lottos;

    public LottoPool() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    public int size() {
        return lottos.size();
    }

    public void display() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
