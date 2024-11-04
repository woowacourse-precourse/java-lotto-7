package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

import static lotto.exception.ErrorMessage.INVALID_PURCHASE_MONEY;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUM_MIN = 1;
    private static final int LOTTO_NUM_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    public void validatePurchaseMoney(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_MONEY.getMessage());
        }
    }

    public int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUM_MIN, LOTTO_NUM_MAX, LOTTO_SIZE);
        numbers.sort(Integer::compareTo);
        return new Lotto(numbers);
    }
}
