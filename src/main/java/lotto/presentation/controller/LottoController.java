package lotto.presentation.controller;

import lotto.application.dto.LottoTicketsDTO;
import lotto.application.service.LottoService;
import lotto.application.validation.BaseValidation;
import lotto.application.validation.BonusNumberValidation;
import lotto.application.validation.BonusNumberValidator;
import lotto.application.validation.LottoNumberValidator;
import lotto.domain.model.LottoNumbers;
import lotto.domain.model.LottoTickets;
import lotto.domain.result.LottoResult;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;

import java.util.List;


public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseValidation<Integer> amountValidator;
    private final LottoService lottoService;
    private final BaseValidation<List<Integer>> lottoNumberValidator;
    private final BonusNumberValidation bonusNumberValidator;

    public LottoController(InputView inputView, OutputView outputView, BaseValidation<Integer> amountValidator, LottoService lottoService, BaseValidation<List<Integer>> lottoNumberValidator, BonusNumberValidation  bonusNumberValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.amountValidator = amountValidator;
        this.lottoService = lottoService;
        this.lottoNumberValidator = lottoNumberValidator;
        this.bonusNumberValidator = bonusNumberValidator;
    }

    public void start() {
        int amount = getValidAmount();

        lottoService.purchaseLotto(amount);

        LottoTickets lottoTickets = lottoService.getLottoTicketsFromRepository();
        LottoTicketsDTO lottoTicketsDTO = new LottoTicketsDTO(lottoTickets.getTickets());
        outputView.printLottoTickets(lottoTicketsDTO);

        LottoNumbers winningNumbers = getValidWinningNumbers();

        int bonusNumber = getValidBonusNumber(winningNumbers.getNumbers());

        LottoResult result = lottoService.calculateResults(lottoTickets, winningNumbers, bonusNumber);
        double profitRate = lottoService.calculateProfitRate(result, amount);
        outputView.printResults(result, profitRate);

    }

    private int getValidAmount() {
        while (true) {
            try {
                String amountInput = inputView.inputPurchaseAmount();
                return amountValidator.validate(amountInput);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
    private LottoNumbers getValidWinningNumbers() {
        while (true) {
            try {
                String winningNumbersInput = inputView.inputWinningNumbers();
                List<Integer> winningNumbers = lottoNumberValidator.validate(winningNumbersInput);
                return new LottoNumbers(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
    private int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = inputView.inputBonusNumber();
                return bonusNumberValidator.validateBonusNumber(bonusNumberInput, winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
