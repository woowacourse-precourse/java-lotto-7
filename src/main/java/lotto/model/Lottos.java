package lotto.model;

import java.util.List;
import java.util.function.Consumer;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void forEachLotto(Consumer<Lotto> action) {
        lottos.forEach(action);
    }
}
