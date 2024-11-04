package lotto.model;

import static lotto.constant.LottoConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;
import lotto.exception.ExactChangeNotPossibleException;

public class LottoShop {

    public Lottos buy(Integer price) {
        validatePrice(price);
        return generateLottos(calculateLottoTicketCount(price));
    }

    private Lottos generateLottos(int buyCount) {
        return new Lottos(
                IntStream.range(ZERO, buyCount)
                        .mapToObj(i -> generateLotto())
                        .toList()
        );
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT));
    }

    private int calculateLottoTicketCount(Integer price) {
        return price / LOTTO_PRICE;
    }

    private void validatePrice(Integer price) {
        if (!isExactChangePossible(price)) {
            throw new ExactChangeNotPossibleException();
        }
    }

    private boolean isExactChangePossible(Integer price) {
        return price % LOTTO_PRICE == ZERO;
    }

}
