package lotto.model;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getLottoCount() {
        return lottos.size();
    }
}
