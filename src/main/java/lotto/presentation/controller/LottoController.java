package lotto.presentation.controller;

import lotto.application.dto.LottoTicketsDTO;
import lotto.application.service.LottoService;
import lotto.application.validation.BaseValidation;
import lotto.domain.model.LottoTickets;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;


public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseValidation<Integer> amountValidator;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, BaseValidation<Integer> amountValidator, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.amountValidator = amountValidator;
        this.lottoService = lottoService;
    }

    public void start() {
        int amount = getValidAmount();

        lottoService.purchaseLotto(amount);

        LottoTickets lottoTickets = lottoService.getLottoTicketsFromRepository();
        LottoTicketsDTO lottoTicketsDTO = new LottoTicketsDTO(lottoTickets.getTickets());
        outputView.printLottoTickets(lottoTicketsDTO);
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
}
