package lotto.game;

import lotto.domain.LottoPool;
import lotto.service.LottoConverter;
import lotto.service.WinningNumberChecker;
import lotto.service.WinningStatisticsManager;
import lotto.ui.InputManager;
import lotto.ui.OutputManager;

import java.math.BigInteger;

public class LottoGame {
    private final WinningNumberChecker winningNumberChecker = new WinningNumberChecker();
    private final OutputManager outputManager = new OutputManager();
    private final LottoPool lottoPool = new LottoPool();
    private final WinningStatisticsManager winningStatisticsManager = new WinningStatisticsManager(winningNumberChecker);
    private final InputManager inputManager = new InputManager();

    public void start(){
        outputManager.requestMoney();
        BigInteger money =inputManager.validateMoney(inputManager.validateEmptyAndReturnInput());
        lottoPool.makeRandomLotto(new LottoConverter().MoneyToLotto(money));
        OutputManager.printPurchasedLotto(lottoPool.getLottosDrawn());
        outputManager.requestWinningNumber();
        winningNumberChecker.setWinningNumber(inputManager.validateAndReturnNumbers(inputManager.validateEmptyAndReturnInput()));
        outputManager.requestBonusNumber();
        winningNumberChecker.setBonusNumber(inputManager.validateBonusNumber(inputManager.validateEmptyAndReturnInput()));
        lottoPool.getLottosDrawn().forEach(winningStatisticsManager::increaseAll);
        outputManager.printStatistics(winningStatisticsManager.getWinningStatistics(),
                winningStatisticsManager.getEarningRate(money));
    }
}
