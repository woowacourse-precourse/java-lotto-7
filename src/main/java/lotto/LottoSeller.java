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
            lottos.add(makeLotto(makeLottoNumber()));
        }
        return lottos;
    }

    protected Lotto makeLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    protected List<Integer> makeLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().toList();
    }

    public int getLottoCount() {
        return cash / lottoPrice;
    }
}
