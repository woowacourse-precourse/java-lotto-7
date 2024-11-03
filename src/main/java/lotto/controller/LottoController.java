package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.dto.LottoResponse;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        List<LottoResponse> lottoResponses = generateLottos(purchaseAmount);
        outputView.printFormattedLottoNumbers(lottoResponses);

        List<String> winningLottoNumbers = readWinningLottoNumbers();

        int bonusNumberInput = inputView.readBonusNumberInput();
        LottoNumber bonusNumber = new LottoNumber(bonusNumberInput);
    }

    private List<String> readWinningLottoNumbers() {
        String lottoNumbersInput = inputView.readLottoNumbersInput();
        return Arrays.stream(lottoNumbersInput.split(",")).toList();
    }

    private PurchaseAmount readPurchaseAmount() {
        outputView.promptPurchaseAmount();
        int purchaseAmountInput = inputView.readPurchaseAmountInput();

        return new PurchaseAmount(purchaseAmountInput);
    }

    private List<LottoResponse> generateLottos(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.calculatePurchasableLottoCount();
        outputView.printPurchasableLottoCount(lottoCount);

        return lottoService.generateLottos(lottoCount);
    }
}
