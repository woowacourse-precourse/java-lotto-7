package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}

