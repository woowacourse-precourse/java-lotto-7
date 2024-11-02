package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.LottoPurchaseAmount;

public class LottoService {
    public Lottos buyLottos(LottoPurchaseAmount lottoPurchaseAmount) {
        int range = lottoPurchaseAmount.lottoPurchaseAmount() / 1000;

        Lottos lottos = new Lottos();

        for (int i = 0; i < range; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.addLotto(lotto);
        }

        return lottos;
    }
}
