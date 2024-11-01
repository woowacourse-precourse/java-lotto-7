package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.exception.PurchaseMoneyInvalidException;

import java.util.List;
import java.util.stream.IntStream;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    public Lottos purchaseLottos(int money) {

        validateMoney(money);
        int lottoCount = money / LOTTO_PRICE;

        return new Lottos(IntStream.range(0, lottoCount)
                .mapToObj(i -> makeLotto())
                .toList());
    }

    private Lotto makeLotto() {
        return new Lotto(makeLottoNumbers());
    }

    private List<LottoNumber> makeLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_NUMBER_SIZE).stream()
                .sorted()
                .map(LottoNumber::from)
                .toList();
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw PurchaseMoneyInvalidException.lottoMoneyTooSmall();
        }

        if (money % LOTTO_PRICE != 0) {
            throw PurchaseMoneyInvalidException.lottoMoneyNotDivisible();
        }
    }
}
