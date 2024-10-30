package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.Arrays;

public class LottoGame {
    private final WinningNumberChecker winningNumberChecker = new WinningNumberChecker();
    private final OutputManager outputManager = new OutputManager();
    private final LottoPool lottoPool = new LottoPool();
    private final WinningStatisticsManager winningStatisticsManager = new WinningStatisticsManager(winningNumberChecker);

    public void start(){
        outputManager.requestMoney();
        int money = Integer.parseInt(Console.readLine());
        lottoPool.makeRandomLotto(new LottoConverter().MoneyToLotto(BigInteger.valueOf(money)));
        OutputManager.printPurchasedLotto(lottoPool.getLottosDrawn());
        outputManager.requestWinningNumber();
        winningNumberChecker.setWinningNumber(Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt).toList());
        outputManager.requestBonusNumber();
        winningNumberChecker.setBonusNumber(Integer.parseInt(Console.readLine()));
        lottoPool.getLottosDrawn().forEach(winningStatisticsManager::increaseAll);
        outputManager.printStatistics(winningStatisticsManager.getWinningStatistics(),
                winningStatisticsManager.getEaringRate(BigInteger.valueOf(money)));
    }
}
