package lotto.domain.entity;

import java.util.Iterator;
import java.util.List;

public record Lottos(List<Lotto> lottos) implements Iterable<Lotto> {

    @Override
    public Iterator<Lotto> iterator() {
        return this.lottos.iterator();
    }
}
