package lotto.service;

import java.util.List;
import lotto.domain.Amount;
import lotto.domain.LottoBundle;

public class LottoPurchase {

    public static final int LOTTO_PRICE = 1000;

    private LottoBundle bundle;

    public void purchase(Amount amount) {
        bundle = new LottoBundle(amount.getValue() / LOTTO_PRICE);
    }

    public List<String> retrievePurchasedLottoNumbers() {
        return bundle.retrieveLottoNumbers();
    }
}
