package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static final int LOTTO_PRICE = 1000;
    private LottoGenerator lottoGenerator;

    public LottoStore() {
        this.lottoGenerator = new LottoGenerator();
    }

    public int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public List<Lotto> sell(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            lottos.add(lottoGenerator.generate());
        }
        return lottos;
    }
}
