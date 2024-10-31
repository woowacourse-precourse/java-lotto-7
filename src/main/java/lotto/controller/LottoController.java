package lotto.controller;

import java.util.List;
import lotto.ApplicationConfig;
import lotto.common.util.StringSplitter;
import lotto.dto.LottoResult;
import lotto.dto.LottoTickets;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoIssuer;
import lotto.model.LottoResultCalculator;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final ApplicationConfig applicationConfig;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
        this.inputView = applicationConfig.inputView();
        this.outputView = applicationConfig.outputView();
    }

    public void execute() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        LottoTickets lottoTickets = getLottoTickets(purchaseAmount);
        printPurchaseResult(lottoTickets);
        WinningLotto winningLotto = getWinningLotto();
        LottoResult lottoResult = getLottoResult(winningLotto, lottoTickets, purchaseAmount);
        printLottoResult(lottoResult);
    }

    private PurchaseAmount getPurchaseAmount() {
        while (true) {
            try {
                String input = inputView.requestPurchaseAmount();
                InputValidator.validateIsNumeric(input);
                return new PurchaseAmount(Integer.parseInt(input));
            } catch (IllegalArgumentException ex) {
                outputView.printExceptionMessage(ex.getMessage());
            }
        }
    }

    private LottoTickets getLottoTickets(final PurchaseAmount purchaseAmount) {
        LottoIssuer lottoIssuer = applicationConfig.lottoIssuer();
        return lottoIssuer.issueLottoTickets(purchaseAmount);
    }

    private void printPurchaseResult(LottoTickets lottoTickets) {
        outputView.printCountOfLottoTickets(lottoTickets.size());
        outputView.printLottoTickets(lottoTickets);
    }

    private WinningLotto getWinningLotto() {
        Lotto lotto = getLotto();
        outputView.printBlankLine();
        while (true) {
            try {
                String input = inputView.requestBonusNumber();
                outputView.printBlankLine();
                InputValidator.validateIsNumeric(input);
                BonusNumber bonusNumber = new BonusNumber(Integer.parseInt(input));
                return new WinningLotto(lotto, bonusNumber);
            } catch (IllegalArgumentException ex) {
                outputView.printExceptionMessage(ex.getMessage());
            }
        }
    }

    private Lotto getLotto() {
        LottoIssuer lottoIssuer = applicationConfig.lottoIssuer();
        while (true) {
            try {
                List<String> splitInput = StringSplitter.splitByComma(inputView.requestWinningNumbers());
                List<Integer> numbers = splitInput.stream()
                        .map(Integer::parseInt)
                        .toList();
                return lottoIssuer.issueLotto(numbers);
            } catch (IllegalArgumentException ex) {
                outputView.printExceptionMessage(ex.getMessage());
            }
        }
    }

    private LottoResult getLottoResult(
            final WinningLotto winningLotto,
            final LottoTickets lottoTickets,
            final PurchaseAmount purchaseAmount
    ) {
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningLotto);
        return lottoResultCalculator.getLottoResult(lottoTickets, purchaseAmount);
    }

    private void printLottoResult(final LottoResult lottoResult) {
        outputView.printWinningStatistics(lottoResult);
    }
}
