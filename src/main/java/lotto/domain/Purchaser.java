package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Purchaser {

    private final List<Lotto> purchasedLotto;

    public Purchaser(Budget budget) {
        purchasedLotto = new ArrayList<>();
        purchaseLotto(budget);
    }

    private void purchaseLotto(Budget budget) {
        int lottoQuantity = budget.getAmount() / LottoInfo.PRICE;
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> numbers = LottoNumbersGenerator.generate();
            purchasedLotto.add(new Lotto(numbers));
        }
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }
}
