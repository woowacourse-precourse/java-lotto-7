package lotto.model;

import java.util.List;

public class Seller {
    private static final int LOTTO_PRICE = 1000;
    private final LottoGenerator lottoGenerator;

    public Seller(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void sellTo(Customer customer) {
        int numberToBuy = (int)customer.getBudget() / LOTTO_PRICE;
        List<Lotto> generated = lottoGenerator.generate(numberToBuy);
        customer.buyLotto(generated);
    }
}
