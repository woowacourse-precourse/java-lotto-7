package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import lotto.model.WinningCriteria;
import lotto.model.WinningResult;
import lotto.service.InputParsingService;
import lotto.service.InputValidationService;
import lotto.service.LottoCalculationService;
import lotto.service.LottoIssueService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidationService inputValidationService;
    private final InputParsingService inputParsingService;
    private final LottoIssueService lottoIssueService;
    private final LottoCalculationService lottoCalculationService;

    public LottoController(
            InputView inputView,
            OutputView outputView,
            InputValidationService inputValidationService,
            InputParsingService inputParsingService,
            LottoIssueService lottoIssueService,
            LottoCalculationService lottoCalculationService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidationService = inputValidationService;
        this.inputParsingService = inputParsingService;
        this.lottoIssueService = lottoIssueService;
        this.lottoCalculationService = lottoCalculationService;
    }

    public void runLotto() {
        PurchasePrice purchasePrice = inputPurchasePrice();
        List<Lotto> issuedLotto = lottoIssueService.issueLotto(purchasePrice);
        printIssuedLotto(issuedLotto);
        WinningCriteria winningCriteria = inputWinningCriteria();
        WinningResult winningResult = calculateWinningResult(issuedLotto, winningCriteria);
        double rateOfReturn = calculateRateOfReturn(purchasePrice, winningResult);
        printWinningResult(winningResult);
        printRateOfReturn(rateOfReturn);
    }

    private PurchasePrice inputPurchasePrice() {
        outputView.printPurchasePriceInputMessage();
        String rawPurchasePrice = inputView.inputContent();
        inputValidationService.validatePurchasePrice(rawPurchasePrice);
        return inputParsingService.parsePurchasePrice(rawPurchasePrice);
    }

    private void printIssuedLotto(List<Lotto> issuedLotto) {
        outputView.printIssuedLottoCount(issuedLotto.size());
        outputView.printIssuedLotto(issuedLotto);
    }

    private WinningCriteria inputWinningCriteria() {
        Lotto winningLotto = inputWinningLotto();
        BonusNumber bonusNumber = inputBonusNumber(winningLotto.getNumbers());
        return new WinningCriteria(winningLotto, bonusNumber);
    }

    private Lotto inputWinningLotto() {
        outputView.printWinningNumberInputMessage();
        String rawWinningNumber = inputView.inputContent();
        inputValidationService.validateWinningNumber(rawWinningNumber);
        return inputParsingService.parseWinningLotto(rawWinningNumber);
    }

    private BonusNumber inputBonusNumber(List<Integer> banNumbers) {
        outputView.printBonusNumberInputMessage();
        String rawBonusNumber = inputView.inputContent();
        inputValidationService.validateBonusNumber(rawBonusNumber);
        return inputParsingService.parseBonusNumber(rawBonusNumber, banNumbers);
    }

    private WinningResult calculateWinningResult(List<Lotto> issuedLotto, WinningCriteria winningCriteria) {
        return lottoCalculationService.calculateWinning(issuedLotto, winningCriteria);
    }

    private double calculateRateOfReturn(PurchasePrice purchasePrice, WinningResult winningResult) {
        return lottoCalculationService.calculationRateOfReturn(purchasePrice, winningResult);
    }

    private void printWinningResult(WinningResult winningResult) {
        outputView.printWinningResult(winningResult);
    }

    private void printRateOfReturn(double rateOfReturn) {
        outputView.printRateOfReturn(rateOfReturn);
    }
}
