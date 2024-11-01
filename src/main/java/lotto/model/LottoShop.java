package lotto.model;

import lotto.model.exception.PurchaseMoneyInvalidException;
import lotto.model.number_generator.RandomLottoNumberGenerator;

import java.util.stream.IntStream;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;

    public Lottos purchaseRandomLottos(int money, RandomLottoNumberGenerator randomLottoNumberGenerator) {

        validateMoney(money);
        int lottoCount = money / LOTTO_PRICE;

        return new Lottos(IntStream.range(0, lottoCount)
                .mapToObj(count -> makeLotto(randomLottoNumberGenerator))
                .toList());
    }

    private Lotto makeLotto(RandomLottoNumberGenerator randomLottoNumberGenerator) {
        LottoNumbers lottoNumbers = new LottoNumbers(randomLottoNumberGenerator.generate());
        return new Lotto(lottoNumbers);
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw PurchaseMoneyInvalidException.lottoMoneyTooSmall();
        }

        if (money % LOTTO_PRICE != 0) {
            throw PurchaseMoneyInvalidException.lottoMoneyNotDivisible();
        }
    }
}
