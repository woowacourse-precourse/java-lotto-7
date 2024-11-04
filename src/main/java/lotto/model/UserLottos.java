package lotto.model;


import lotto.provider.NumberProvider;
import lotto.provider.RandomNumberProvider;

import java.util.ArrayList;
import java.util.List;

public class UserLottos {
    private final NumberProvider numberProvider;
    private final List<Lotto> lottos = new ArrayList<>();
    private final int lottoCount;
    private final int purchasePrice;

    public UserLottos(int lottoCount, int purchasePrice) {
        this.numberProvider = new RandomNumberProvider();
        this.lottoCount = lottoCount;
        this.purchasePrice = purchasePrice;

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(numberProvider.getNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getTotalPrice() { return purchasePrice; }
}
