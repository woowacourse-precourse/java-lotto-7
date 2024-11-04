package lotto.service.purchase;

import static lotto.constant.Error.INVALID_UNIT_PURCHASE;
import static lotto.constant.LottoConstant.PRICE;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.service.NumbersSelector;

public class PurchaseServiceImpl implements PurchaseService {

    private final NumbersSelector numbersSelector;

    public PurchaseServiceImpl(NumbersSelector numbersSelector) {
        this.numbersSelector = numbersSelector;
    }

    @Override
    public LottoPurchase purchase(int payAmount) {
        validatePayAmount(payAmount);
        int lottoAmount = payAmount / PRICE;

        List<Lotto> lottos = IntStream.range(0, lottoAmount)
            .mapToObj(sequence -> new Lotto(numbersSelector.select()))
            .toList();

        return LottoPurchase.purchase(lottos);
    }

    private static void validatePayAmount(int payAmount) {
        if (payAmount % PRICE != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_PURCHASE);
        }
    }
}
