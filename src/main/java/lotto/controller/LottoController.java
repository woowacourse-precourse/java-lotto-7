package lotto.controller;

import java.util.List;
import lotto.dto.WinningResult;
import lotto.util.InputParser;
import lotto.model.evaluate.LottoResultEvaluator;
import lotto.model.win.BonusNumber;
import lotto.model.shop.LottoShop;
import lotto.model.ticket.LottoTickets;
import lotto.model.win.LottoWinningSet;
import lotto.model.shop.TicketSeller;
import lotto.model.win.WinningNumbers;
import lotto.util.RetryHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoShop lottoShop;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        lottoShop = LottoShop.open();
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoTickets lottoTickets = purchaseAndShowLottoTickets();
        LottoWinningSet winningSet = getWinningSetFromUserInput();
        evaluateAndShowResults(winningSet, lottoTickets);
    }

    private LottoTickets purchaseAndShowLottoTickets() {
        LottoTickets lottoTickets = RetryHandler.retryIfError(this::getLottoTicketsFromUserInput);
        showPurchasedTickets(lottoTickets);
        return lottoTickets;
    }

    private LottoTickets getLottoTicketsFromUserInput() {
        int purchaseAmount = getPurchaseAmountFromUser();
        return generateLottoTickets(purchaseAmount);
    }

    private int getPurchaseAmountFromUser() {
        String rawInputPurchaseAmount = inputView.requestPurchaseAmount();
        return InputParser.validateAndParsePurchaseAmount(rawInputPurchaseAmount);
    }

    private LottoTickets generateLottoTickets(int purchaseAmount) {
        TicketSeller ticketSeller = lottoShop.findTicketSeller();
        return ticketSeller.exchangeMoneyForTickets(purchaseAmount);
    }

    private void showPurchasedTickets(LottoTickets lottoTickets) {
        outputView.printPurchasedQuantity(lottoTickets.getCount());
        outputView.printLottoTickets(lottoTickets.getAllNumbers());
    }

    private LottoWinningSet getWinningSetFromUserInput() {
        WinningNumbers winningNumbers = RetryHandler.retryIfError(this::getWinningNumbersFromUser);
        return RetryHandler.retryIfError(() -> {
            BonusNumber bonusNumber = getBonusNumberFromUser();
            return getLottoWinningSet(winningNumbers, bonusNumber);
        });
    }

    private WinningNumbers getWinningNumbersFromUser() {
        String rawInputWinningNumbers = inputView.requestWinningNumbers();
        List<Integer> numbers = InputParser.validateAndParseWinningNumbers(rawInputWinningNumbers);
        return new WinningNumbers(numbers);
    }

    private BonusNumber getBonusNumberFromUser() {
        String rawInputBonusNumber = inputView.requestBonusNumber();
        int bonusNumber = InputParser.validateAndParseBonusNumber(rawInputBonusNumber);
        return new BonusNumber(bonusNumber);
    }

    private LottoWinningSet getLottoWinningSet(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new LottoWinningSet(winningNumbers, bonusNumber);
    }

    private void evaluateAndShowResults(LottoWinningSet winningSet, LottoTickets lottoTickets) {
        WinningResult winningResult = evaluateLotto(winningSet, lottoTickets);
        showWinningResult(winningResult);
    }

    private WinningResult evaluateLotto(LottoWinningSet winningSet, LottoTickets lottoTickets) {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator(winningSet);
        return lottoResultEvaluator.evaluate(lottoTickets);
    }

    private void showWinningResult(WinningResult winningResult) {
        outputView.printWinningResult(winningResult);
    }
}
