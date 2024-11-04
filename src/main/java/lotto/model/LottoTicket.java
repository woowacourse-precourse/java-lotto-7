package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
