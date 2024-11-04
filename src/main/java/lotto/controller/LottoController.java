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
        String purchaseAmount = getValidatedPurchaseAmount();
        List<Lotto> lottos = createAndDisplayLottos(purchaseAmount);
        processAndDisplayResults(lottos, purchaseAmount);
    }

    private String getValidatedPurchaseAmount() {
        OutputView.showPrompt(PURCHASE_AMOUNT);
        String purchaseNumber = getValidInput(InputValidator::validatePurchaseAmount);

        return  purchaseNumber;
    }

    private List<Lotto> createAndDisplayLottos(String purchaseAmount) {
        List<Lotto> lottos = lottoService.generateLotto(purchaseAmount);
        OutputView.showLottoNumbers(lottos);

        return lottos;
    }

    private void processAndDisplayResults(List<Lotto> lottos, String purchaseAmount) {
        String winningNumbers = getValidatedWinningNumbers();
        String bonusNumber = getValidatedBonusNumber(winningNumbers);

        Map<Integer, Integer> matchCounts = lottoService.winningDetermination(winningNumbers, bonusNumber, lottos);
        double yield = lottoService.calculateYield(matchCounts, purchaseAmount);

        OutputView.showFinalResult(matchCounts, yield);
    }

    private String getValidatedWinningNumbers() {
        OutputView.showPrompt(WINNING_NUMBERS);
        String winningNumbers = getValidInput(InputValidator::validateWinningNumbers);

        return winningNumbers;
    }

    private String getValidatedBonusNumber(String winningNumbers) {
        OutputView.showPrompt(BONUS_NUMBER);
        String bonusNumber = getValidInput(input -> InputValidator.validateBonusNumber(winningNumbers, input));

        return bonusNumber;
    }

    private String getValidInput(Consumer<String> validator) {
        while (true) {
            try {
                String input = InputView.getInput();
                validator.accept(input);

                return input;
            } catch (IllegalArgumentException e) {
                OutputView.showErrorMessage(e.getMessage());
            }
        }
    }
}
