package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final LottoNumGenerator lottoNumGenerator;

    public LottoService(LottoNumGenerator lottoNumGenerator) {
        this.lottoNumGenerator = lottoNumGenerator;
    }

    public PurchasedLotto issueLottoNumAsPurchaseQuantity(final int quantity) {
        List<Lotto> lottos = issueLotto(quantity);
        return new PurchasedLotto(lottos);
    }

    private List<Lotto> issueLotto(final int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        return new Lotto(lottoNumGenerator);
    }
}
