package lotto.model;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    public int getLottosSize() {
        return lottos.size();
    }
    public Lotto getLotto(int idx) {
        return lottos.get(idx);
    }
}
