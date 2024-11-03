package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.MatchStatistics;
import lotto.domain.WinningNumber;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.util.RandomNumberGenerator;

public class LottoController {
    private final InputController inputController;
    private final OutputController outputController;
    private final LottoManager lottoManager;
    private final LottoStatisticsController statisticsController;

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler,
                           RandomNumberGenerator randomNumberGenerator) {
        this.outputController = new OutputController(outputHandler);
        this.inputController = new InputController(inputHandler, this.outputController);
        this.lottoManager = new LottoManager(randomNumberGenerator);
        this.statisticsController = new LottoStatisticsController();
    }

    public void startLotto() {
        while (true) {
            try {
                executeLottoProcess();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void executeLottoProcess() {
        outputController.showLottoPrice();
        String price = inputController.getPrice();
        int lottoCount = lottoManager.getLottoCount(price);

        MatchStatistics matchStatistics = new MatchStatistics();
        matchStatistics.setTotalSpent(Double.parseDouble(price));
        outputController.showLottoCount(lottoCount);

        List<Lotto> lottoNumbers = lottoManager.generateLottoNumbers(lottoCount);
        showLottoNumbers(lottoNumbers);

        WinningNumber winningNumber = inputController.getWinningNumber();
        updateMatchStatistics(lottoNumbers, winningNumber, matchStatistics);
    }

    private void showLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            outputController.showLottoList(lotto.getNumbers());
        }
    }

    private void updateMatchStatistics(List<Lotto> lottoNumbers, WinningNumber winningNumber,
                                       MatchStatistics matchStatistics) {
        statisticsController.calculateMatches(lottoNumbers, winningNumber, matchStatistics);
        outputController.showMatchResult(matchStatistics.getMatchResults(), matchStatistics.getProfitRate());
    }
}
