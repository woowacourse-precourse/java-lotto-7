package lotto.mvc.controller;

import java.math.BigDecimal;
import java.util.EnumMap;
import lotto.mvc.model.LottoManager;
import lotto.mvc.model.LottoReturnCalculator;
import lotto.mvc.model.LottoWinningAmount;
import lotto.mvc.model.WinningLotto;
import lotto.mvc.view.OutputView;

public class LottoController {
    private InputHandler inputHandler;
    private OutputView outputView;
    private LottoManager lottoManager;

    public LottoController(InputHandler inputHandler, OutputView outputView, LottoManager lottoManager) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
        this.lottoManager = lottoManager;
    }

    public void run() {
        long purchaseAmount = inputHandler.getPurchaseAmount();

        int count = lottoManager.extractLottoCount(purchaseAmount);

        lottoManager.makeLottoes(count);
        outputView.showPurchaseDetails(lottoManager.getLottoes(), count);

        lottoManager.setWinningLotto(inputHandler.getLottoWinningNumbers());
        WinningLotto winningLotto = lottoManager.getWinningLotto();
        int bonusNumber = inputHandler.getLottoBonusNumber(winningLotto);
        lottoManager.setBonusNumber(bonusNumber);

        EnumMap<LottoWinningAmount, Integer> winningCounts = lottoManager.checkLottoWinning();
        outputView.showWinningStatisticsDetails(winningCounts);

        BigDecimal totalReturn = LottoReturnCalculator.calculateTotalReturn(winningCounts, purchaseAmount);

        outputView.showTotalReturn(totalReturn);
    }
}
