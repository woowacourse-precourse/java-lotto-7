package lotto.domain;

import static lotto.message.CommonConstants.LOTTO_PRICE;
import static lotto.message.CommonConstants.ZERO;

import lotto.domain.generator.LottoNumberGenerator;

public class LottoIssuer {

    public static Lottos issue(PurchaseAmount purchaseAmount, LottoNumberGenerator lottoNumberGenerator) {
        int lottoCount = purchaseAmount.getPurchaseAmount() / LOTTO_PRICE;
        Lottos lottos = new Lottos();

        for (int i = ZERO; i < lottoCount; i++) {
            lottos.addLotto(lottoNumberGenerator);
        }

        return lottos;
    }
    
}