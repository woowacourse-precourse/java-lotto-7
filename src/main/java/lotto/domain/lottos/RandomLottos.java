package lotto.domain.lottos;

import java.util.List;

public class RandomLottos {
    private final List<Lotto> lottos;

    public RandomLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }


}
