package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos = new ArrayList<>();

    public void purchaseLottos(int purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }
    }
}
