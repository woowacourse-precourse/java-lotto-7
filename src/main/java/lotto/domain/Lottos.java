package lotto.domain;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(Collection<Lotto> lottos) {
        this.lottos = new LinkedList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }
}
