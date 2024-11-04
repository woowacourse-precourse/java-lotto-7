package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.dto.LottoResponse;
import lotto.dto.PrizeResponse;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
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
        generateLottos(purchaseAmount);
        outputView.printFormattedLottoNumbers(findGeneratedLottos());

        Lotto winningLotto = readWinningLottoNumbers();

        LottoNumber bonusNumber = readBonusNumber();

        List<PrizeResponse> winningResult = lottoService.findWinningResult(winningLotto, bonusNumber);
    }



    private PurchaseAmount readPurchaseAmount() {
        outputView.promptPurchaseAmount();
        int purchaseAmountInput = inputView.readPurchaseAmountInput();

        return new PurchaseAmount(purchaseAmountInput);
    }

    private void generateLottos(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.calculatePurchasableLottoCount();
        outputView.printPurchasableLottoCount(lottoCount);
        lottoService.generateLottos(lottoCount);
    }

    private List<LottoResponse> findGeneratedLottos() {
        return lottoService.findAll();
    }

    private Lotto readWinningLottoNumbers() {
        outputView.promptLottoNumbers();
        String lottoNumbersInput = inputView.readLottoNumbersInput();
        List<Integer> winningLottoNumbers = Arrays.stream(lottoNumbersInput.split(","))
                .map(Integer::parseInt)
                .toList();

        return new Lotto(winningLottoNumbers);
    }

    private LottoNumber readBonusNumber() {
        outputView.promptBonusNumber();
        int bonusNumberInput = inputView.readBonusNumberInput();

        return new LottoNumber(bonusNumberInput);
    }
}
