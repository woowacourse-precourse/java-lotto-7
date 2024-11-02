package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    private int cash;
    private int lottoPrice;

    public LottoSeller(int cash, int lottoPrice) {
        this.cash = cash;
        this.lottoPrice = lottoPrice;
    }

    protected List<Lotto> sell() {
        int lottoNumbers = getLottoCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoNumbers; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }


    public int getLottoCount() {
        return cash / Lotto.PRICE;
    }
}
