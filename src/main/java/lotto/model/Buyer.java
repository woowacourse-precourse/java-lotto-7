package lotto.model;

import java.util.List;

public class Buyer {
    private List<Lotto> lottos;

    public Buyer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
