package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoSeller {
    private final LottoFactory lottoFactory = new LottoFactory();

    public List<Lotto> buyLotto(int amount) {
        int count = calculatePurchaseCount(amount);
        return provideLotto(count);
    }

    public int calculatePurchaseCount(int amount) {
        return amount / 1000;
    }

    public List<Lotto> provideLotto(int count) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotto.add(lottoFactory.createLotto());
        }
        return lotto;
    }
}