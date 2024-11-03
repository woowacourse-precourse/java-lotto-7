package lotto.controller;

import lotto.model.Lotto;
import lotto.service.OutputService;
import lotto.view.OutputView;

import java.util.List;

public class OutputController {
    private final OutputService outputService;
    private final OutputView outputView;

    public OutputController(OutputService outputService, OutputView outputView) {
        this.outputService = outputService;
        this.outputView = outputView;
    }

    public void displayLottoCount(int lottoCount) {
        String message = outputService.getLottoCountMessage(lottoCount);
        outputView.printMessage(message);
    }

    public void displayLottos(List<Lotto> lottos) {
        String message = outputService.getLottosMessage(lottos);
        outputView.printMessage(message);
    }

    public void displayWinningStatistics(int[] matchCounts) {
        String message = outputService.getLottoStatisticsMessage(matchCounts);
        outputView.printMessage(message);
    }

    public void displayYield(double yield) {
        String message = outputService.getYieldMessage(yield);
        outputView.printMessage(message);
    }
}
