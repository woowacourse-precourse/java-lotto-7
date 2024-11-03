package lotto.model;

import static lotto.constant.LottoConstants.LOTTO_PRICE;
import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;
import static lotto.constant.LottoConstants.NUMBER_COUNT;
import static lotto.constant.LottoConstants.ZERO;

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
