package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoManager lottoManager;

    public LottoController(InputView inputView, OutputView outputView, LottoManager lottoManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoManager = lottoManager;
    }

    public void run() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        lottoManager.generateLottoNumbers(purchaseAmount);

        List<Lotto> lottoNumbers = lottoManager.getLottoNumbers();
        outputView.printLottoNumbers(lottoNumbers.size(), lottoManager.getLottoNumbers());

        List<Integer> winningNumbers = inputView.inputWinningNumber();
    }
}
