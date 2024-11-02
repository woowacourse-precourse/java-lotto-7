package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createLottos(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public int getSize() {
        return lottos.size();
    }
}
