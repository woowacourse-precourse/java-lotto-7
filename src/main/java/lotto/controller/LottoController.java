package lotto.controller;

import java.util.List;
import lotto.model.Lottos;
import lotto.service.LottoNumberGenerator;
import lotto.service.PriceCalculator;
import lotto.view.input.PurchasePriceInput;

public class LottoController {

    private final PurchasePriceInput purchasePriceInput;
    private final PriceCalculator priceCalculator;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoController(PriceCalculator priceCalculator, PurchasePriceInput purchasePriceInput, LottoNumberGenerator lottoNumberGenerator) {
        this.purchasePriceInput = purchasePriceInput;
        this.priceCalculator = priceCalculator;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void start() {
        String price = purchasePriceInput.getPurchasePrice();
        int lottoCount = priceCalculator.calculateLotto(price);
        Lottos generatedLottos = lottoNumberGenerator.generateLottoNumbers(lottoCount);
    }
}

