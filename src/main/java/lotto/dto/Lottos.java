package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public void addLottos(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
