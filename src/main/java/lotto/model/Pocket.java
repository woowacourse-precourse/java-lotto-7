package lotto.model;

import java.util.List;

public class Pocket {
    List<Lotto> lottos;

    public Pocket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
