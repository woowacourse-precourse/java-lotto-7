package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoResultCalculator lottoResultCalculator;

    private final LottoNumGenerator lottoNumGenerator;

    public LottoService(final LottoResultCalculator lottoResultCalculator, final LottoNumGenerator lottoNumGenerator) {
        this.lottoResultCalculator = lottoResultCalculator;
        this.lottoNumGenerator = lottoNumGenerator;
    }

    public PurchasedLotto issueLottoNumAsPurchaseQuantity(final int quantity) {
        List<Lotto> lottos = issueLotto(quantity);
        return new PurchasedLotto(lottos);
    }

    public LottoResult checkLottoResult(final List<Lotto> purchasedLotto, final WinningLotto winningLotto) {
        return lottoResultCalculator.calculateResult(purchasedLotto, winningLotto);
    }

    public double calcRate(final int purchasePrice, final LottoResult lottoResult) {
        return lottoResult.calculateRate(purchasePrice);
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
