package lotto.controller;

import static lotto.view.Prompt.BONUS_NUMBER;
import static lotto.view.Prompt.PURCHASE_AMOUNT;
import static lotto.view.Prompt.WINNING_NUMBERS;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        String purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);

        displayFormattedLottoNumbers(lottos);

        String winningNumbers = getWinningNumbers();
        String bonusNumber = getBonusNumber(winningNumbers);

        Map<Integer, Integer> matchCounts = lottoService.winningDetermination(winningNumbers, bonusNumber, lottos);

        displayResults(matchCounts, purchaseAmount);
    }

    private void displayResults(Map<Integer, Integer> matchCounts, String purchaseAmount) {
        OutputView.displayWinningResult(matchCounts);

        double yield = lottoService.calculateYield(matchCounts, purchaseAmount);

        OutputView.displayYield(yield);
    }

    private String getBonusNumber(String winningNumbers) {
        OutputView.displayPrompt(BONUS_NUMBER);
        String bonusNumber = getValidInput(input -> InputValidator.validateBonusNumber(winningNumbers, input));

        return bonusNumber;
    }

    private String getWinningNumbers() {
        OutputView.displayPrompt(WINNING_NUMBERS);
        String winningNumbers = getValidInput(InputValidator::validateWinningNumbers);

        return winningNumbers;
    }

    private void displayFormattedLottoNumbers(List<Lotto> lottos) {
        String formattedLottoNumbers = lottoService.getFormattedLottoNumbers(lottos);

        OutputView.displayLottoNumbers(lottos.size(), formattedLottoNumbers);
    }

    private String getPurchaseAmount() {
        OutputView.displayPrompt(PURCHASE_AMOUNT);

        return getValidInput(InputValidator::validatePurchaseAmount);
    }

    private String getValidInput(Consumer<String> validator) {
        while (true) {
            try {
                String input = InputView.getInput();
                validator.accept(input);

                return input;
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }
}
