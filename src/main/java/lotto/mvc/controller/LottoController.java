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
        long purchaseAmount = getPurchaseAmount();

        int lottoCount = calculateLottoCount(purchaseAmount);

        createAndDisplayLottoes(lottoCount);

        getWinningLotto();

        displayWinningStatistics(purchaseAmount);
    }

    private long getPurchaseAmount() {
        return inputHandler.getPurchaseAmount();
    }

    private int calculateLottoCount(long purchaseAmount) {
        return lottoManager.extractLottoCount(purchaseAmount);
    }

    private void createAndDisplayLottoes(int lottoCount) {
        lottoManager.makeLottoes(lottoCount);
        outputView.showPurchaseDetails(lottoManager.getLottoes(), lottoCount);
    }

    private void getWinningLotto() {
        lottoManager.setWinningLotto(inputHandler.getLottoWinningNumbers());
        getBonusNumber();
    }

    private void getBonusNumber() {
        WinningLotto winningLotto = lottoManager.getWinningLotto();
        int bonusNumber = inputHandler.getLottoBonusNumber(winningLotto);
        lottoManager.setBonusNumber(bonusNumber);
    }

    private void displayWinningStatistics(long purchaseAmount) {
        EnumMap<LottoWinningAmount, Integer> winningCounts = lottoManager.checkLottoWinning();
        outputView.showWinningStatisticsDetails(winningCounts);
        BigDecimal totalReturn = calculateTotalReturn(winningCounts, purchaseAmount);
        outputView.showTotalReturn(totalReturn);
    }

    private BigDecimal calculateTotalReturn(EnumMap<LottoWinningAmount, Integer> winningCounts, long purchaseAmount) {
        return LottoReturnCalculator.calculateTotalReturn(winningCounts, purchaseAmount);
    }
}
