package lotto.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


public class Lottos implements Iterable<Lotto> {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }
}
