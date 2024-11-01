package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoBuyService {

    private static final String PURCHASE_AMOUNT_IS_POSITIVE_NUMBER = "[ERROR] 로또 구입 금액은 양의 정수여야 합니다.";
    private static final String PURCHASE_AMOUNT_DIVIDED_BY_1000 = "[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.";

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;

    public Lottos buyLotto(final String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);

        Lottos lottos = new Lottos();
        for (int i = 0; i < Long.parseLong(purchaseAmount) / LOTTO_PRICE; i++) {
            lottos.addLotto(selectLottoNumbers());
        }

        return lottos;
    }

    public Lotto selectLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private void validatePurchaseAmount(final String purchaseAmount) {
        validatePurchaseAmountIsPositiveNumber(purchaseAmount);
        validatePurchaseAmountDividedBy1000(purchaseAmount);
    }

    private void validatePurchaseAmountIsPositiveNumber(final String purchaseAmount) {
        if (!purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_POSITIVE_NUMBER);
        }
    }

    private void validatePurchaseAmountDividedBy1000(final String purchaseAmount) {
        if (Long.parseLong(purchaseAmount) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_DIVIDED_BY_1000);
        }
    }
}
