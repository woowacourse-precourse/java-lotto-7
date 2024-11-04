package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoRandomUtil;

public class LottoPurchaseHistory {
    private List<Lotto> purchaseHistory;

    public LottoPurchaseHistory(int amount) {
        initializePurchaseHistory(amount);
    }

    public LottoPurchaseHistory(List<Lotto> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    private void initializePurchaseHistory(int amount) {
        purchaseHistory = new ArrayList<>();
        for (int total = 0; total < amount; total++) {
            purchaseHistory.add(buyLotto());
        }
    }

    private Lotto buyLotto() {
        return new Lotto(LottoRandomUtil.chooseRandomNumber());
    }

    public List<Lotto> getPurchaseHistory() {
        return purchaseHistory;
    }
}
