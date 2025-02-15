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
        this.lottos = createLottos();
    }

    public List<Lotto> createLottos() {
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            generatedLottos.add(new Lotto(numbers));
        }
        return generatedLottos;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
