package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPurchaseController {

    private static final int LOTTO_PRICE = 1000;

    public Lottos purchaseLottos(long userPurchaseMoney) {
        long purchasedLottoCount = userPurchaseMoney / LOTTO_PRICE;
        Lottos lottos = Lottos.createLottos(new ArrayList<>());
        purchaseLotto(purchasedLottoCount, lottos);
        return lottos;
    }

    private void purchaseLotto(long purchasedLottoCount, Lottos lottos) {
        for (int count = 0; count < purchasedLottoCount; count++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            Lotto lotto = Lotto.createLotto(numbers);
            lottos.addLotto(lotto);
        }
    }
}