package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstants;

public final class Lottos {
    public final List<Lotto> lottos;

    public Lottos(int purchaseQuantity) {
        lottos = new ArrayList<Lotto>();
        purchaseLottos(purchaseQuantity);
    }

    public void purchaseLottos(int purchaseQuantity) {
        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(
                    LottoConstants.MIN_LOTTO_NUMBER,
                    LottoConstants.MAX_LOTTO_NUMBER,
                    LottoConstants.LOTTO_SIZE);
            lottos.add(new Lotto(lottoNumber));
        }
    }
}
