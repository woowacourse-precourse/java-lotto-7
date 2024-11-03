package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPool {
    private List<Lotto> lottos;

    private void LottoPool() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }
}
