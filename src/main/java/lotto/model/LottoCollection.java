package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoCollection {
    private final List<Lotto> lottos;

    public LottoCollection(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }
    
    public List<Lotto> getLottos() {
        return lottos;
    }
}
