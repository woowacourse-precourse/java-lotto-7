package lotto.model;

import java.util.List;
import java.util.function.Consumer;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    // 각 Lotto 객체에 대해 제공된 액션(Consumer 인터페이스)을 수행
    public void forEachLotto(Consumer<Lotto> action) {
        lottos.forEach(action);
    }
}
