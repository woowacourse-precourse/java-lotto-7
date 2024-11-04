package lotto.presentation.controller;

import lotto.application.dto.LottoTicketsDTO;
import lotto.application.service.LottoService;
import lotto.application.validation.BaseValidation;
import lotto.application.validation.LottoNumberValidator;
import lotto.domain.model.LottoNumbers;
import lotto.domain.model.LottoTickets;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;

import java.util.List;


public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseValidation<Integer> amountValidator;
    private final LottoService lottoService;
    private final BaseValidation<List<Integer>> lottoNumberValidator;

    public LottoController(InputView inputView, OutputView outputView, BaseValidation<Integer> amountValidator, LottoService lottoService, BaseValidation<List<Integer>> lottoNumberValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.amountValidator = amountValidator;
        this.lottoService = lottoService;
        this.lottoNumberValidator = lottoNumberValidator;
    }

    public void start() {
        int amount = getValidAmount();

        lottoService.purchaseLotto(amount);

        LottoTickets lottoTickets = lottoService.getLottoTicketsFromRepository();
        LottoTicketsDTO lottoTicketsDTO = new LottoTicketsDTO(lottoTickets.getTickets());
        outputView.printLottoTickets(lottoTicketsDTO);

        LottoNumbers winningNumbers = getValidWinningNumbers();

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
}
