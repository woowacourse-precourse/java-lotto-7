package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos;

    public LottoGame(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult calculateResult(Lotto winningLotto, int bonusNumber) {
        return new LottoResult(this, winningLotto, bonusNumber);
    }
}
