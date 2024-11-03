package lotto.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.lotto.providable.NumbersProvidable;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos from(int numOfLottos, NumbersProvidable numbersProvidable) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numOfLottos; i++) {
            lottos.add(Lotto.create(numbersProvidable));
        }

        return new Lottos(lottos);
    }
}
