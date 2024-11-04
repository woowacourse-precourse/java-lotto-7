package lotto;

import java.util.List;

public class TotalLotto {
    private List<Lotto> totalLotto;

    public TotalLotto(List<Lotto> totalLotto) {
        this.totalLotto= totalLotto;
    }

    public List<Lotto> getLottos() {
        return totalLotto;
    }
}
