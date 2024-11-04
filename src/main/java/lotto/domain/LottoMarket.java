package lotto.domain;

import static lotto.constant.Constant.LOTTO_PRICE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

public class LottoMarket {

    private final LottoMaker lottoMaker = new LottoMaker();

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
            throw new LottoException(ExceptionCode.NEGATIVE_NUMBER);
        }
    }

    private void validateDivisibleByThousand(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new LottoException(ExceptionCode.NON_DIVISIBLE_BY_THOUSAND);
        }
    }

    private int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }
}
