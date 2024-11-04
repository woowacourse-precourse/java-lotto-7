package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private int lottoCnt;
    private List<Lotto> lottos;

    public LottoGenerator(int lottoCnt) {
        this.lottoCnt = lottoCnt;
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoCnt() {
        return lottoCnt;
    }

}
