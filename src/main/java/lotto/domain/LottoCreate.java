package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoCreate {
    private int purchasePrice;
    private int lottoCount;
    private List<Lotto> lottos;

    public LottoCreate(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        lottoCount = purchasePrice / 1000;
        createLottos();
    }

    public void createLottos() {
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
