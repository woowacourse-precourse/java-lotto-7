package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.SystemMessage;

public class LottoController {
    private final LottoService lottoService;
    private final long numberOfLottery;
    private final List<Integer> winningLottery;
    public final int bonusLottery;

    public LottoController() {
        numberOfLottery = InputView.getInstance().enterPaymentForLottery();
        System.out.println("\n" + numberOfLottery + SystemMessage.NUMBER_OF_LOTTERY);
        lottoService = new LottoService(numberOfLottery);
        lottoService.getLotteries().forEach(each -> System.out.println(each.getNumbers()));

        winningLottery = InputView.getInstance().enterWinningLottery();
        bonusLottery = InputView.getInstance().enterBonusLottery();

    }

    public void start() {
        System.out.println(SystemMessage.WINNING_STATISTICS);
        lottoService.getStatistics(winningLottery, bonusLottery);
        OutputView.getInstance().printWinningStatistics(lottoService.getWinningCounts());
        OutputView.getInstance().printRateOfReturn(lottoService.getWinningCounts(), numberOfLottery);
    }
}
