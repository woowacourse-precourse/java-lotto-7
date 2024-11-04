package lotto.app;

import java.util.List;
import java.util.Map;
import lotto.config.AppConfig;
import lotto.domain.Lotto;
import lotto.domain.Score;
import lotto.service.LottoService;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class Application {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoService lottoService;

    public Application(InputHandler inputHandler, OutputHandler outputHandler, LottoService lottoService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoService = lottoService;
    }

    public static void main(String[] args) {
        Application application = AppConfig.createApplication();
        application.run();
    }

    public void run() {
        int purchaseAmount = inputHandler.getPurchaseAmount();
        List<Lotto> lottos = lottoService.purchaseLottos(purchaseAmount);
        outputHandler.printLottos(lottos);

        List<Integer> winningNums = inputHandler.getWinningNums();
        int bonusNum = inputHandler.getBonusNum(winningNums);

        Lotto successLotto = lottoService.generateWinningLotto(winningNums);
        List<Score> scores = lottoService.calculateScores(lottos, successLotto, bonusNum);
        displayResult(scores, purchaseAmount);
    }

    private void displayResult(List<Score> scores, int purchaseAmount) {
        Map<Score, Integer> scoreCount = lottoService.calculateScoreCount(scores);
        int totalPrizeMoney = lottoService.calculateTotalPrizeMoney(scores);
        double rateOfReturn = lottoService.calculateRateOfReturn(totalPrizeMoney, purchaseAmount);
        outputHandler.printLottosResult(scoreCount);
        outputHandler.printRateOfReturn(rateOfReturn);
    }
}