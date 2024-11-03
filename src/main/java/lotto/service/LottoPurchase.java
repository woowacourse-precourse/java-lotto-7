package lotto.service;

import static lotto.domain.Amount.LOTTO_PRICE;

import java.util.List;
import lotto.domain.Amount;
import lotto.domain.LottoBundle;

public class LottoPurchase {

    private LottoBundle bundle;

    public void purchase(Amount amount) {
        bundle = new LottoBundle(amount.getValue() / LOTTO_PRICE);
    }

    public List<String> retrievePurchasedLottoNumbers() {
        return bundle.retrieveLottoNumbers();
    }

    public LottoBundle getBundle() {
        return bundle;
    }
}
