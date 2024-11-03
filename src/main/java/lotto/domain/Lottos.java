package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Ranks draw(Draw draw) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Rank rank = draw.compare(lotto);
            ranks.add(rank);
        }
        return new Ranks(ranks);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(this.lottos);
    }

}
