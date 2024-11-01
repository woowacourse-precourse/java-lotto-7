package lotto.model;

import java.util.HashMap;
import java.util.List;

public class Buyer {
    private List<Lotto> lottos;
    private HashMap<Rank, Integer> resultLotto = new HashMap<>();

    public Buyer(List<Lotto> lottos) {
        this.lottos = lottos;
        initResultLotto();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private void initResultLotto() {
        for (Rank rank : Rank.values()) {
            this.resultLotto.put(rank, 0);
        }
    }
}
