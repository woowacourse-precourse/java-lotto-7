package lotto.Factory;

import lotto.Domain.PrizeMoneyCalculator;
import lotto.Domain.PurchasePriceCalculator;
import lotto.Domain.RandomLottoNumbersGenerator;

public class LottoDomainFactory {
    public PrizeMoneyCalculator createPrizeMoneyCalculator() {
        return new PrizeMoneyCalculator();
    }

    public PurchasePriceCalculator createPurchasePriceCalculator() {
        return new PurchasePriceCalculator();
    }

    public RandomLottoNumbersGenerator createRandomLottoNumbersGenerator() {
        return new RandomLottoNumbersGenerator();
    }
}
