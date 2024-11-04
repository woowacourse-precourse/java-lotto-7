package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.dto.LottoResponse;
import lotto.dto.PrizeResponse;
import lotto.service.LottoService;
import lotto.view.ConsoleView;

import java.util.Arrays;
import java.util.List;

public class LottoController {
    private final ConsoleView consoleView;
    private final LottoService lottoService;

    public LottoController(ConsoleView consoleView, LottoService lottoService) {
        this.consoleView = consoleView;
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        generateLottos(purchaseAmount);
        consoleView.printFormattedLottoNumbers(findGeneratedLottos());

        Lotto winningLotto = readWinningLottoNumbers();

        LottoNumber bonusNumber = readBonusNumber();

        List<PrizeResponse> winningResult = lottoService.findWinningResult(winningLotto, bonusNumber);
        consoleView.printWinningResult(winningResult);

        double profitRate = lottoService.calculateProfitRate(purchaseAmount, winningResult);
        consoleView.printProfitRate(profitRate);
    }



    private PurchaseAmount readPurchaseAmount() {
        int purchaseAmountInput = consoleView.readPurchaseAmountInput();

        return new PurchaseAmount(purchaseAmountInput);
    }

    private void generateLottos(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.calculatePurchasableLottoCount();
        consoleView.printPurchasableLottoCount(lottoCount);
        lottoService.generateLottos(lottoCount);
    }

    private List<LottoResponse> findGeneratedLottos() {
        return lottoService.findAll();
    }

    private Lotto readWinningLottoNumbers() {
        String winningLottoNumbersInput = consoleView.readWinningLottoNumbersInput();
        List<Integer> winningLottoNumbers = Arrays.stream(winningLottoNumbersInput.split(","))
                .map(Integer::parseInt)
                .toList();

        return new Lotto(winningLottoNumbers);
    }

    private LottoNumber readBonusNumber() {
        int bonusNumberInput = consoleView.readBonusNumberInput();

        return new LottoNumber(bonusNumberInput);
    }
}
