package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.WinningResult;
import lotto.error.InputValidator;
import lotto.model.evaluate.LottoResultEvaluator;
import lotto.model.ticket.LottoShop;
import lotto.model.ticket.LottoTickets;
import lotto.model.ticket.TicketSeller;
import lotto.util.InputUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoShop lottoShop;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        lottoShop = LottoShop.openShop();
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = InputUtil.retryIfNeeded(this::readPurchaseAmount);
        LottoTickets lottoTickets = purchaseLottoTickets(purchaseAmount);
        displayLotto(lottoTickets);
        List<Integer> winningNumbers = InputUtil.retryIfNeeded(this::readWinningNumbers);
        int bonusNumber = InputUtil.retryIfNeeded(() -> readBonusNumber(winningNumbers));
        WinningResult winningResult = evaluateLotto(winningNumbers, bonusNumber, lottoTickets);
        displayResult(winningResult);
    }

    private int readPurchaseAmount() {
        String rawInputPurchaseAmount = inputView.requestPurchaseAmount();
        validatePurchaseAmount(rawInputPurchaseAmount);
        return Integer.parseInt(rawInputPurchaseAmount);
    }

    private void validatePurchaseAmount(String rawInput) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.validatePurchaseAmount(rawInput);
    }

    private LottoTickets purchaseLottoTickets(int purchaseAmount) {
        TicketSeller ticketSeller = lottoShop.findTicketSeller();
        return ticketSeller.exchangeMoneyForTickets(purchaseAmount);
    }

    private void displayLotto(LottoTickets lottoTickets) {
        outputView.printPurchasedQuantity(lottoTickets.getCount());
        outputView.printLottoTickets(lottoTickets.getAllNumbers());
    }

    private List<Integer> readWinningNumbers() {
        String rawInputWinningNumbers = inputView.requestWinningNumbers();
        validateWinningNumbers(rawInputWinningNumbers);
        return parseWinningNumbers(rawInputWinningNumbers);
    }

    private void validateWinningNumbers(String rawInput) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.validateWinningNumbers(rawInput);
    }

    private List<Integer> parseWinningNumbers(String rawInput) {
        String[] separatedInputs = rawInput.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String input : separatedInputs) {
            winningNumbers.add(Integer.parseInt(input.trim()));
        }
        return winningNumbers;
    }

    private int readBonusNumber(List<Integer> winningNumbers) {
        String rawInputBonusNumber = inputView.requestBonusNumber();
        validateBonusNumber(rawInputBonusNumber, winningNumbers);
        return Integer.parseInt(rawInputBonusNumber);
    }

    private void validateBonusNumber(String rawInput, List<Integer> winningNumbers) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.validateBonusNumber(rawInput, winningNumbers);
    }

    private WinningResult evaluateLotto(List<Integer> winningNumbers, int bonusNumber, LottoTickets lottoTickets) {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator(winningNumbers, bonusNumber);
        return lottoResultEvaluator.evaluate(lottoTickets);
    }

    private void displayResult(WinningResult winningResult) {
        outputView.printWinningResult(winningResult);
    }
}
