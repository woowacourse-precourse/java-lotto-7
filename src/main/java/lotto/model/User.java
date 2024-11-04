package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Lotto> lotto;

    public User(int amountToBuy) {
        this.lotto = buyLotto(amountToBuy);
    }

    private List<Lotto> buyLotto(int amount) {
        List<Lotto> lotto = new ArrayList<Lotto>();
        for (int i = 0; i < amount; i++) {
            lotto.add(new Lotto());
        }
        return lotto;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }
}
