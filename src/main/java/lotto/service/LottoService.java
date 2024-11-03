package lotto.service;

import lotto.model.LottoPurchaseHistory;

public class LottoService {
    public LottoPurchaseHistory buyLotto(int amount) {
        return new LottoPurchaseHistory(amount);
    }
}
