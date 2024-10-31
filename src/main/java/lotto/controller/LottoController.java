package lotto.controller;

import lotto.enums.OutputMessage;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startLottoSales() {
        boolean isValidNumber = false;
        String inputCost;

        do {
            outputView.printMessage(OutputMessage.INPUT_PURCHASE_AMOUNT);
            inputCost = inputView.InputPurchaseAmount();

            try {
                lottoService.isValidNumber(inputCost);
                isValidNumber = true;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        } while (!isValidNumber);

        int parsedPurchaseAmount = lottoService.parseStringToInt(inputCost);
    }


}
