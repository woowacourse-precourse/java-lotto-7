package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import static lotto.LottoConstants.*;

public class LottoGenerator {
    private boolean isValidMinimumPrice(int budget) {
        return budget >= PRICE_PER_LOTTO.getValue();
    }

    private boolean isValidPriceUnit(int budget) {
        return budget % PRICE_PER_LOTTO.getValue() == 0;
    }

    public int getLottoCount(int budget) {
        if (!isValidMinimumPrice(budget)) {
            throw new IllegalArgumentException("[ERROR] " + PRICE_PER_LOTTO.getValue() + "원 이상의 금액을 입력하세요.");
        }
        if (!isValidPriceUnit(budget)) {
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
