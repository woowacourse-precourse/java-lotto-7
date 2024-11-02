package lotto.domain;

import lotto.utils.NumbersGenerator;
import lotto.validator.LottoStoreValidator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.LottoValue.LOTTO_PRICE;

public class LottoStore {
    private final NumbersGenerator numbersGenerator;

    public LottoStore(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public LottoTicket buyLottoTicket(final int price) {
        LottoStoreValidator.validatePurchaseAmount(price);
        return new LottoTicket(IntStream.range(0, price / LOTTO_PRICE.getValue())
                .mapToObj(i -> Lotto.from(numbersGenerator.createNumbers()))
                .collect(Collectors.toList()));
    }
}
