package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class LottoGenerator {
    static final int PRICE_PER_LOTTO = 1000;

    public int getLottoCount(int budget) {
        if (budget < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException("[ERROR] " + PRICE_PER_LOTTO + "원 이상의 금액을 입력하세요.");
        }
        if (budget % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] " + PRICE_PER_LOTTO + "원 단위로만 구매 가능합니다.");
        }
        return budget / PRICE_PER_LOTTO;
    }

    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

}
