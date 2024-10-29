package lotto.domain.model;

import lotto.common.constant.LottoConst;

import java.util.List;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> issueByAmount(int amount) {
        int quantity = amountToQuantity(amount);
        return lottoGenerator.generate(quantity);
    }

    private int amountToQuantity(int amount) {
        return amount / LottoConst.LOTTO_PRICE;
    }
}
