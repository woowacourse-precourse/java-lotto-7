package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.service.CommonWinningStrategy;
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
        bonusLottery = InputView.getInstance().enterBonusLottery(winningLottery);

    }

    public void start() {
        System.out.println(SystemMessage.WINNING_STATISTICS);
        lottoService.getStatistics(winningLottery, bonusLottery);

        for (Map.Entry<CommonWinningStrategy, Integer> entry : lottoService.getWinningCounts().entrySet()) {
            OutputView.getInstance().printWinningStatistics(entry.getKey(), entry.getValue());
        }
        OutputView.getInstance().printRateOfReturn(lottoService.getWinningCounts(), numberOfLottery);

    }

    public void end() {
        InputView.getInstance().close();
    }
}
