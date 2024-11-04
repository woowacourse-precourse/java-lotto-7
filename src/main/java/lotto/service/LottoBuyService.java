package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoBuyService {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;

    public Lottos buyLotto(final String purchaseAmount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < Long.parseLong(purchaseAmount) / LOTTO_PRICE; i++) {
            lottos.addLotto(selectLottoNumbers());
        }

        return lottos;
    }

    public Lotto selectLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
        return new Lotto(numbers);
    }
}
