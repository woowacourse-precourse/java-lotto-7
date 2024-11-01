package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {
    private final List<Lotto> purchasedLotto = new ArrayList<Lotto>();

    public PurchasedLotto(int purchasedLottoCount) {
        purchaseLotto(purchasedLottoCount);
    }

    private void purchaseLotto(int purchasedLottoCount) {
        for (int i = 0; i < purchasedLottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLotto.add(new Lotto(lottoNumbers));
        }
    }

    //    public List<Lotto> getPurchasedLotto() {
//        return purchasedLotto;
//    }
    public List<Lotto> getLotto() {
        return purchasedLotto;
    }
}
