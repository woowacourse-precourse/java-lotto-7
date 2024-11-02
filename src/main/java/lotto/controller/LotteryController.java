package lotto.controller;

import lotto.domain.Money;
import lotto.domain.WinningInfo;
import lotto.service.LotteryService;
import lotto.util.InputProcessor;
import lotto.view.OutputView;

public class LotteryController {

    private final InputProcessor inputProcessor = new InputProcessor();
    private final OutputView outputView = new OutputView();

    public void run() {
        Money money = inputProcessor.createMoney();
        WinningInfo winningInfo = inputProcessor.getWinningInfo();
        LotteryService service = new LotteryService(money, winningInfo);
    }
}
