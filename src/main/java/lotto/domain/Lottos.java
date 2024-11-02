package lotto.domain;

import java.util.*;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(Collection<Lotto> lottos) {
        this.lottos = new LinkedList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
