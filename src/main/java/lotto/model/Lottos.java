package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(final int lottoCount) {
        lottos = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> toList() {
        return List.copyOf(lottos);
    }

    public int count() {
        return lottos.size();
    }
}
