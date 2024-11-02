package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import lotto.model.WinningCriteria;
import lotto.service.InputParsingService;
import lotto.service.InputValidationService;
import lotto.service.LottoIssueService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidationService inputValidationService;
    private final InputParsingService inputParsingService;
    private final LottoIssueService lottoIssueService;

    public LottoController(
            InputView inputView,
            OutputView outputView,
            InputValidationService inputValidationService,
            InputParsingService inputParsingService,
            LottoIssueService lottoIssueService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidationService = inputValidationService;
        this.inputParsingService = inputParsingService;
        this.lottoIssueService = lottoIssueService;
    }

    public void runLotto() {
        PurchasePrice purchasePrice = inputPurchasePrice();
        List<Lotto> issuedLotto = lottoIssueService.issueLotto(purchasePrice);
        printIssuedLotto(issuedLotto);
        WinningCriteria winningCriteria = inputWinningCriteria();
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
}
