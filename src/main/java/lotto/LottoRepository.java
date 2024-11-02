package lotto;

import java.util.List;

public class LottoRepository {
    private Lottos lottos;

    public void saveRandomLottos(List<Lotto> lottos) {
        this.lottos = new Lottos(lottos);
    }

    public Lottos loadRandomLottos() {
        return lottos;
    }
}
