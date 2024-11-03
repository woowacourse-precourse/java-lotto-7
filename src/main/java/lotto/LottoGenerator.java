package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import static lotto.LottoConstants.*;

public class LottoGenerator {
    public int getLottoCount(int budget) {
        if (budget < PRICE_PER_LOTTO.getValue()) {
            throw new IllegalArgumentException("[ERROR] " + PRICE_PER_LOTTO.getValue() + "원 이상의 금액을 입력하세요.");
        }
        if (budget % PRICE_PER_LOTTO.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] " + PRICE_PER_LOTTO.getValue() + "원 단위로만 구매 가능합니다.");
        }
        return budget / PRICE_PER_LOTTO.getValue();
    }

    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER.getValue(),
                MAX_NUMBER.getValue(),
                SELECTED_NUMBER_COUNT.getValue()
        );
        return new Lotto(numbers);
    }
}
