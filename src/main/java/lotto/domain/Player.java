package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class Player {

    private final List<Lotto> lottos;

    public static Player create(List<Lotto> lottos) {
        return new Player(lottos);
    }

    private Player(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
