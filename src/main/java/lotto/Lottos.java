package lotto;

import java.util.Set;

public class Lottos {

    private final Set<Lotto> lottos;

    public Lottos(Set<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Set<Lotto> getLottos() {
        return lottos;
    }
}
