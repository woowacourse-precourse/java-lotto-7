package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.Lotto;

public class LottoMarket {

    private final LottoMaker lottoMaker = new LottoMaker();

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> buyLotto(int money) {

        validateMoney(money);
        int lottoCount = calculateLottoCount(money);

        return Stream.generate(lottoMaker::makeLotto)
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    private void validateMoney(int money) {
        validatePositive(money);
        validateDivisibleByThousand(money);
    }

    private void validatePositive(int money) {
        if (money < 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivisibleByThousand(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }
}
