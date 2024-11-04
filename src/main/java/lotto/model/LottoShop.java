package lotto.model;

import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;
import static lotto.constant.LottoConstants.NUMBER_COUNT;
import static lotto.constant.LottoConstants.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;

public class LottoShop {

    public Lottos buy(Price price) {
        return generateLottos(price.calculateLottoTicketCount());
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
}
