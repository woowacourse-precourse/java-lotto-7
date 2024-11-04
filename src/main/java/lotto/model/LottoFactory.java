package lotto.model;

import lotto.validation.LottoFactoryValidator;

import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {

    public static List<Lotto> drawLottoesByPrice(PriceToBuyLotto priceToBuyLotto) {
        int lottoCount = Integer.divideUnsigned(priceToBuyLotto.price(), 1000);

        List<Lotto> lottoes = IntStream.range(0, lottoCount)
                .mapToObj(i -> Lotto.drawLotto())
                .toList();

        LottoFactoryValidator.validateLottoFactory(lottoes, priceToBuyLotto);
        return lottoes;
    }
}
