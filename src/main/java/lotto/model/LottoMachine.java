package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;
    private static final int LOTTO_PRICE = 1000;

    private List<Integer> lottoNums;

    public void initMachine() {
        lottoNums = new ArrayList<>();
        for (int i = LOTTO_START_NUM; i <= LOTTO_END_NUM; i++) {
            lottoNums.add(i);
        }
    }

    public Lottos issueLottos(int purchaseAmount) {
        int purchaseCount = (purchaseAmount / LOTTO_PRICE);
        Lottos lottos = new Lottos();
        for (int i = purchaseCount; i > 0; i--) {
            lottos.addLotto(issueLotto());
        }
        return lottos;
    }

    private Lotto issueLotto() {
        Collections.shuffle(lottoNums);
        return new Lotto(lottoNums.subList(0, 6));
    }
}
