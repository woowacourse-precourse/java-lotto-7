package lotto.domain;

import static lotto.message.CommonConstants.LOTTO_PRICE;
import static lotto.message.CommonConstants.ZERO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.generator.LottoNumberGenerator;

public class LottoIssuer {

    public static Lottos issue(PurchaseAmount purchaseAmount, LottoNumberGenerator lottoNumberGenerator) {
        int lottoCount = purchaseAmount.getPurchaseAmount() / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = ZERO; i < lottoCount; i++) {
            lottos.add(createLotto(lottoNumberGenerator));
        }

        return new Lottos(lottos);
    }

    private static Lotto createLotto(LottoNumberGenerator lottoNumberGenerator) {
        List<Integer> numbers = lottoNumberGenerator.generate();
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

}
