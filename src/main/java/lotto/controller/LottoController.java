package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.enums.OutputMessage;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    private int parsedCostToInt;
    private int purchasedLottoCount;
    private LottoCollection lottoCollection;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startPurchaseAmountInput() {
        boolean isValidNumber = false;
        String inputCost;

        do {
            outputView.printMessage(OutputMessage.INPUT_PURCHASE_AMOUNT);
            inputCost = inputView.inputPurchaseAmount();

            try {
                parsedCostToInt = lottoService.isValidNumber(inputCost);
                isValidNumber = true;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        } while (!isValidNumber);
    }

    public void printNumberOfPurchaseLotto() {
        purchasedLottoCount = lottoService.divideInputByLottoPrice(parsedCostToInt);
        String lottoCountMessage = OutputMessage.PURCHASED_LOTTO_COUNT_MESSAGE
                .getLottoCountMessage(purchasedLottoCount);
        outputView.printLottoCountMessage(lottoCountMessage);
    }

    public void generateLottosByRandomNumber() {
        this.lottoCollection = lottoService.generateLottoCollection(purchasedLottoCount);
    }

    public void printLottoNumbers() {
        List<Lotto> lottoNumbers = lottoService.prepareCollectionForPrint(lottoCollection);
        outputView.printLottoNumbers(lottoNumbers);

    }


}
