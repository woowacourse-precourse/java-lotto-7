package lotto.model;

import java.util.List;

public class Lottos {

    private final int count;
    private final List<Lotto> lottos;

    public Lottos(int count, List<Lotto> lottos) {
        this.count = count;
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
