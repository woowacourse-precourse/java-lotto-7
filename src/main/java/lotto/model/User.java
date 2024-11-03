package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.config.LottoConfig;

public class User {
    private final List<Lotto> lotto;

    public User(int purchaseAmount) {
        int quantity = calculateQuantity(purchaseAmount);

        this.lotto = buyLotto(quantity);
    }

    private List<Lotto> buyLotto(int quantity) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lotto.add(new Lotto());
        }

        return lotto;
    }

    private int calculateQuantity(int purchaseAmount) {
        return purchaseAmount / LottoConfig.PRICE.getNumber();
    }

    public List<Lotto> getLotto() {
        return lotto;
    }
}
