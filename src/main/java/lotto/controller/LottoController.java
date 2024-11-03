package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.LottoNumberGenerator;
import lotto.service.PriceCalculator;
import lotto.service.WinningNumberParser;
import lotto.view.input.PurchasePriceInput;
import lotto.view.input.WinningNumberInput;
import lotto.view.output.ResultDisplayer;

public class LottoController {

    private final PurchasePriceInput purchasePriceInput;
    private final PriceCalculator priceCalculator;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final ResultDisplayer resultDisplayer;
    private final WinningNumberParser winningNumberParser;
    private final WinningNumberInput winningNumberInput;

    public LottoController(PriceCalculator priceCalculator, PurchasePriceInput purchasePriceInput, LottoNumberGenerator lottoNumberGenerator, ResultDisplayer resultDisplayer, WinningNumberParser winningNumberParser, WinningNumberInput winningNumberInput) {
        this.purchasePriceInput = purchasePriceInput;
        this.priceCalculator = priceCalculator;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.resultDisplayer = resultDisplayer;
        this.winningNumberParser = winningNumberParser;
        this.winningNumberInput = winningNumberInput;
    }

    public void start() {
        String price = purchasePriceInput.getPurchasePrice();
        int lottoCount = priceCalculator.calculateLotto(price);
        Lottos generatedLottos = lottoNumberGenerator.generateLottoNumbers(lottoCount);
        resultDisplayer.showPurchasedLottos(lottoCount, generatedLottos);

        String winningNumber = winningNumberInput.getNumber();
        Lotto parsedWinningNumbers = winningNumberParser.splitWinngNumber(winningNumber);

        String winningBonusNumber = winningNumberInput.getBonusNumber();
        int parsedWinningBonusNumber = winningNumberParser.parseBonusWinningNumber(winningBonusNumber);
    }
}

