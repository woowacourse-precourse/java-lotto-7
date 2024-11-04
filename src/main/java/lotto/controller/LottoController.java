package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final LottoService lottoService;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoService = new LottoService();
        this.outputView = new OutputView();
    }

    public void run() {

        String purchasePriceInput;
        int purchaseAmount;

        while (true) {
            try {
                purchasePriceInput = inputView.inputPurchasePrice();
                System.out.println();
                purchaseAmount = lottoService.validatePurchasePrice(purchasePriceInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        lottoService.generateLottoNumbers(purchaseAmount);

        outputView.printLottoTicketCountAndNumbers(purchaseAmount, lottoService.getLottoTickets());

    }

}
