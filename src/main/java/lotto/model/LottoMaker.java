package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.exception.PurchaseMoneyInvalidException;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMaker {

    private static final int PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    public Lottos makeLottos(int money) {

        validateMoney(money);
        int lottoCount = money / PRICE;

        return new Lottos(IntStream.range(0, lottoCount)
                .mapToObj(i -> makeLotto())
                .toList());
    }

    private Lotto makeLotto() {
        return new Lotto(makeLottoNumbers());
    }

    private List<LottoNumber> makeLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_SIZE).stream()
                .sorted()
                .map(LottoNumber::from)
                .toList();
    }

    private void validateMoney(int money) {
        if (money < PRICE) {
            throw PurchaseMoneyInvalidException.lottoMoneyTooSmall();
        }

        if (money % PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 단위여야 합니다.");
        }
    }
}
