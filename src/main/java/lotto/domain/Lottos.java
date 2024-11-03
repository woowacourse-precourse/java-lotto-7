package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Integer getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        for (Lotto lotto : lottos) {
            display.append(lotto.toString()).append("\n");
        }
        return display.toString();
    }
}
