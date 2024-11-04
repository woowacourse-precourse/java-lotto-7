package lotto.model;

import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {
    private final List<Lotto> lottos;

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
