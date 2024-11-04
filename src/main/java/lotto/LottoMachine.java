package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final static String CHANGE_EXCEPTION_MESSAGE = "금액이 나눠 떨어지지 않습니다";
    private final static int LOTTO_PRICE = 1000;

    public List<Lotto> issueLottosWith(Money money) {
        validateNoChange(money);
        return issueRandomLottos(money.countAvailableFrom(LOTTO_PRICE));
    }

    private void validateNoChange(Money money) {
        if (money.hasChangeWith(LOTTO_PRICE)) {
            throw new IllegalArgumentException(CHANGE_EXCEPTION_MESSAGE);
        }
    }

    private List<Lotto> issueRandomLottos(long count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.createRandomized());
        }
        return lottos;
    }
}
