package lotto.game;

import lotto.domain.IssueRandomLotto;
import lotto.domain.LottoPool;
import lotto.service.LottoConverter;
import lotto.service.WinningNumberChecker;
import lotto.service.WinningNumberPool;
import lotto.service.WinningStatisticsManager;
import lotto.ui.InputManager;
import lotto.ui.OutputManager;

import java.math.BigInteger;

public class LottoGame {
    private final WinningNumberPool winningNumberPool = new WinningNumberPool();
    private final LottoPool lottoPool = new LottoPool();
    private final WinningNumberChecker winningNumberChecker = new WinningNumberChecker(winningNumberPool);
    private final OutputManager outputManager = new OutputManager();
    private final WinningStatisticsManager winningStatisticsManager = new WinningStatisticsManager(winningNumberChecker);
    private final InputManager inputManager = new InputManager();
    private final IssueRandomLotto randomLotto = new IssueRandomLotto();

    public void start() {
        outputManager.requestMoney();
        BigInteger money = inputManager.validateMoney(inputManager.validateEmptyAndReturnInput());
        OutputManager.printPurchasedLotto(IssueRandomLotto.makeRandomLotto(new LottoConverter().MoneyToLotto(money),lottoPool).getLottosDrawn());
        outputManager.requestWinningNumber();
        winningNumberPool.setWinningNumber(inputManager.validateAndReturnNumbers(inputManager.validateEmptyAndReturnInput()));
        outputManager.requestBonusNumber();
        winningNumberPool.setBonusNumber(inputManager.validateBonusNumber(inputManager.validateEmptyAndReturnInput(), winningNumberPool.getWinningNumbers()));
        lottoPool.getLottosDrawn().forEach(winningStatisticsManager::increaseAll);
        outputManager.printStatistics(winningStatisticsManager.getWinningStatistics(), winningStatisticsManager.getEarningRate(money));
    }
}

