package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.WinningResult;
import lotto.model.InputValidator;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResultEvaluator;
import lotto.model.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = readPurchaseAmount();
        LottoTickets lottoTickets = purchaseLotto(purchaseAmount);
        displayLotto(lottoTickets);
        List<Integer> winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber(winningNumbers);
        WinningResult winningResult = evaluateLotto(winningNumbers, bonusNumber, lottoTickets);
        displayResult(winningResult);
    }

    private int readPurchaseAmount() {
        try {
            String rawInputPurchaseAmount = inputView.requestPurchaseAmount();
            validatePurchaseAmount(rawInputPurchaseAmount);
            return Integer.parseInt(rawInputPurchaseAmount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readPurchaseAmount();
        }
    }

    private void validatePurchaseAmount(String rawInput) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.validatePurchaseAmount(rawInput);
    }

    private LottoTickets purchaseLotto(int purchaseAmount) {
        try {
            LottoMachine lottoMachine = new LottoMachine();
            return lottoMachine.purchase(purchaseAmount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return purchaseLotto(purchaseAmount);
        }
    }

    private void displayLotto(LottoTickets lottoTickets) {
        outputView.printPurchasedQuantity(lottoTickets.getCount());
        outputView.printLottoTickets(lottoTickets.getAllNumbers());
    }

    private List<List<Integer>> getLottoTickets(List<Lotto> lottoTickets) {
        return lottoTickets.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    private List<Integer> readWinningNumbers() {
        try {
            String rawInputWinningNumbers = inputView.requestWinningNumbers();
            validateWinningNumbers(rawInputWinningNumbers);
            return parseWinningNumbers(rawInputWinningNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readWinningNumbers();
        }
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
        try {
            String rawInputBonusNumber = inputView.requestBonusNumber();
            validateBonusNumber(rawInputBonusNumber, winningNumbers);
            return Integer.parseInt(rawInputBonusNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readBonusNumber(winningNumbers);
        }
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
