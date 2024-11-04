package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottosResult {
    private final List<LottoResult> purchasedLottosResult;

    public PurchasedLottosResult() {
        purchasedLottosResult = new ArrayList<>();
    }

    public void add(LottoResult matchFlag) {
        purchasedLottosResult.add(matchFlag);
    }

    public List<LottoResult> getPurchasedLottosResult() {
        return purchasedLottosResult;
    }
}
