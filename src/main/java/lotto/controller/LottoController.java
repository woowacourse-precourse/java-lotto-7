package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLottoWithBonus;
import lotto.dto.PrizeResponse;
import lotto.parser.LottoNumbersInputParser;
import lotto.service.LottoService;
import lotto.view.ConsoleView;

import java.util.List;

public class LottoController {
    private final ConsoleView consoleView;
    private final LottoService lottoService;

    public LottoController(ConsoleView consoleView, LottoService lottoService) {
        this.consoleView = consoleView;
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        List<Lotto> purchasedLottos = generateLottos(purchaseAmount);
        consoleView.printPurchasedLottos(purchasedLottos);

        Lotto winningLotto = readWinningLottoNumbers();
        LottoNumber bonusNumber = readBonusNumber();
        WinningLottoWithBonus winningLottoWithBonus = new WinningLottoWithBonus(winningLotto, bonusNumber);

        List<PrizeResponse> winningResult = winningLottoWithBonus.findWinningResult(purchasedLottos);
        consoleView.printWinningResult(winningResult);

        double profitRate = lottoService.calculateProfitRate(purchaseAmount, winningResult);
        consoleView.printProfitRate(profitRate);
    }



    private PurchaseAmount readPurchaseAmount() {
        int purchaseAmountInput = consoleView.readPurchaseAmountInput();

        return new PurchaseAmount(purchaseAmountInput);
    }

    private List<Lotto> generateLottos(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.calculatePurchasableLottoCount();
        consoleView.printPurchasableLottoCount(lottoCount);
        LottoGenerator lottoGenerator = new LottoGenerator();

        return lottoGenerator.generateLottos(lottoCount);
    }

    private Lotto readWinningLottoNumbers() {
        String winningLottoNumbersInput = consoleView.readWinningLottoNumbersInput();
        LottoNumbersInputParser lottoNumbersInputParser = new LottoNumbersInputParser();
        List<String> lottoNumbers = lottoNumbersInputParser.parse(winningLottoNumbersInput);

        return new Lotto(lottoNumbers);
    }

    private LottoNumber readBonusNumber() {
        int bonusNumberInput = consoleView.readBonusNumberInput();

        return new LottoNumber(bonusNumberInput);
    }
}
