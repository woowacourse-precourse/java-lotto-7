package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRound {
    private List<Lotto> lottos;

    public LottoRound() {
        this.lottos = new ArrayList<>();
    }

    public LottoRound(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottosCount() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}
