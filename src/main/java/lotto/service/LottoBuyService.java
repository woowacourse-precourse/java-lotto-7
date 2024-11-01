package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoBuyService {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;
    private static final String INVALID_PURCHASE_AMOUNT = "[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.";

    public Lottos buyLotto(final long purchaseAmount) {
        validate(purchaseAmount);

        Lottos lottos = new Lottos();
        for (int i = 0; i < purchaseAmount / LOTTO_PRICE; i++) {
            lottos.addLotto(selectLottoNumbers());
        }

        return lottos;
    }

    public Lotto selectLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private void validate(final long purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }
}
