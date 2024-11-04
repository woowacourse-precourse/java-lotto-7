package lotto.controller;

import lotto.constants.Message;
import lotto.dto.LottoRequest;
import lotto.dto.LottoResultResponse;
import lotto.dto.LottoTicketDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        try {
            outputView.printMessage(Message.PURCHASE_AMOUNT_PROMPT);
            int purchaseAmount = inputView.getPurchaseAmount();

            List<LottoTicketDto> purchasedTickets = lottoService.generateLottoTickets(purchaseAmount);
            outputView.printPurchaseCount(purchasedTickets.size());
            purchasedTickets.forEach(outputView::printLottoNumbers);

            outputView.printMessage(Message.WINNING_NUMBER_PROMPT);
            List<Integer> winningNumbers = inputView.getWinningNumbers();

            outputView.printMessage(Message.BONUS_NUMBER_PROMPT);
            int bonusNumber = inputView.getBonusNumber();

            LottoRequest lottoRequest = new LottoRequest(purchaseAmount, purchasedTickets, winningNumbers, bonusNumber);
            LottoResultResponse result = lottoService.getLottoResult(lottoRequest);
            outputView.printLottoResult(result);

        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            throw e;
        }
    }
}