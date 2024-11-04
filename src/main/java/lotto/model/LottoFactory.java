package lotto.model;

import lotto.validation.LottoFactoryValidator;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.common.constant.LottoInfo.DEFAULT_LOTTO;

public class LottoFactory {

    public static List<Lotto> drawLottoesByPrice(PriceToBuyLotto priceToBuyLotto) {
        int lottoCount = Integer.divideUnsigned(priceToBuyLotto.price(), DEFAULT_LOTTO.getPriceOfOneLotto());

        List<Lotto> lottoes = IntStream.range(0, lottoCount)
                .mapToObj(i -> Lotto.drawLotto())
                .toList();

        LottoFactoryValidator.validateLottoFactory(lottoes, priceToBuyLotto);
        return lottoes;
    }
}
