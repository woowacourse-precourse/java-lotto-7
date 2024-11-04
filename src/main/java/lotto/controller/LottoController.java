package lotto.controller;

import static lotto.enums.Message.BONUS_NUMBER;
import static lotto.enums.Message.PURCHASE_AMOUNT;
import static lotto.enums.Message.WINNING_NUMBERS;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.enums.Prize;
import lotto.service.LottoService;
import lotto.global.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.enums.Message;

public class LottoController {
    private final InputView inputView;
    private final Validator validator;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, Validator validator, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.validator = validator;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        String purchaseAmount = getValidatedInput(PURCHASE_AMOUNT, validator::validatePurchaseAmount);
        List<Lotto> lottos = lottoService.generateLotto(purchaseAmount);

        outputView.showLottoNumbers(lottos);

        String winningNumbers = getValidatedInput(WINNING_NUMBERS, validator::validateWinningNumbers);
        String bonusNumber = getValidatedInput(BONUS_NUMBER, input -> validator.validateBonusNumber(winningNumbers, input));
        Map<Prize, Integer> matchCounts = lottoService.determineFinalResults(winningNumbers, bonusNumber, lottos);
        BigDecimal rate = lottoService.calculateRate(matchCounts, purchaseAmount);

        outputView.showFinalResult(matchCounts, rate);
    }

    private String getValidatedInput(Message message, InputValidatorFunction validator) {
        outputView.showMessage(message);
        while (true) {
            try {
                String input = inputView.getInput();
                validator.validate(input);
                return input;
            } catch (IllegalArgumentException e) {
                outputView.showErrorMessage(e.getMessage());
            }
        }
    }

    private interface InputValidatorFunction {
        void validate(String input);
    }
}
