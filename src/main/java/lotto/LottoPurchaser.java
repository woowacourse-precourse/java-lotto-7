package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoPurchaser {
    private static final int LOTTO_PRICE = 1000;
    private final int lottoPurchaseCount;

    public LottoPurchaser(String purchaseAmountInput) {
        this.lottoPurchaseCount = Integer.parseInt(purchaseAmountInput) / LOTTO_PRICE;
    }

    public List<Lotto> purchaseLotto() {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < lottoPurchaseCount; i++){
            purchasedLottos.add(generateLotto());
        }
        return purchasedLottos;
    }

    private Lotto generateLotto() {
        return new Lotto(pickUniqueNumbersInRange(1, 45, 6));
    }
}
