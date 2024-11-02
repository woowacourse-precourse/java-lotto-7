package lotto.store;

import lotto.basic.NumbersGenerator;
import lotto.money.Money;
import lotto.money.ProductPrice;

import java.util.LinkedList;
import java.util.List;

public class LottoStore {
    private static final ProductPrice lottoPrice = new ProductPrice(1_000);
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final NumbersGenerator numbersGenerator;

    public LottoStore(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public List<Lotto> sale(Money money) {
        if(lottoPrice.hasChange(money))
            throw new IllegalArgumentException("거스름돈이 발생합니다.");

        return createLotto(lottoPrice.countPurchasableProduct(money));
    }

    private List<Lotto> createLotto(final int purchasableProduct) {
        List<Lotto> result = new LinkedList<>();
        for (int i = 0; i < purchasableProduct ; i++) {
            result.add(new Lotto(toLottoNumbers(generateLottoNumbers())));
        }
        return result;
    }

    private List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new).toList();
    }

    private List<Integer> generateLottoNumbers() {
        return numbersGenerator.random(
                MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE
        );
    }
}
