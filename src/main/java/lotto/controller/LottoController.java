package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = inputView.inputPurchaseAmount();

        LottoManager lottoManager = generateLottoManager(purchaseAmount);

        List<Lotto> lottoNumbers = lottoManager.getLottoNumbers();
        outputView.printLottoNumbers(lottoNumbers.size(), lottoNumbers);

        List<Integer> winningNumbers = inputView.inputWinningNumber();
        outputView.printEmptyLine();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);

        lottoManager.checkLottoResult(winningNumbers, bonusNumber);
        outputView.printLottoResult(lottoManager.getLottoResult(), lottoManager.getPurchaseAmount());
    }

    private LottoManager generateLottoManager(int purchaseAmount) {
        LottoManager lottoManager = new LottoManager(purchaseAmount);
        lottoManager.generateLottoNumbers();
        return lottoManager;
    }
}
