package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.LottoNumberGenerator;
import lotto.service.PriceCalculator;
import lotto.service.WinningNumberSplitter;
import lotto.view.input.PurchasePriceInput;
import lotto.view.input.WinningNumberInput;
import lotto.view.output.ResultDisplayer;

public class LottoController {

    private final PurchasePriceInput purchasePriceInput;
    private final PriceCalculator priceCalculator;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final ResultDisplayer resultDisplayer;
    private final WinningNumberSplitter winningNumberSplitter;
    private final WinningNumberInput winningNumberInput;

    public LottoController(PriceCalculator priceCalculator, PurchasePriceInput purchasePriceInput, LottoNumberGenerator lottoNumberGenerator, ResultDisplayer resultDisplayer, WinningNumberSplitter winningNumberSplitter, WinningNumberInput winningNumberInput) {
        this.purchasePriceInput = purchasePriceInput;
        this.priceCalculator = priceCalculator;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.resultDisplayer = resultDisplayer;
        this.winningNumberSplitter = winningNumberSplitter;
        this.winningNumberInput = winningNumberInput;
    }

    public void start() {
        String price = purchasePriceInput.getPurchasePrice();
        int lottoCount = priceCalculator.calculateLotto(price);
        Lottos generatedLottos = lottoNumberGenerator.generateLottoNumbers(lottoCount);
        resultDisplayer.showPurchasedLottos(lottoCount, generatedLottos);

        String winningNumber = winningNumberInput.getNumber();
        Lotto parsedWinningNumbers = winningNumberSplitter.split(winningNumber);
        String winningBonusNumber = winningNumberInput.getBonusNumber();
    }
}

