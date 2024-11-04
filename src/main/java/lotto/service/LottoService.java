package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Profit;
import lotto.domain.Ranking;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.domain.checker.WinningChecker;
import lotto.domain.extractor.LottoExtractor;
import lotto.io.InputHandler;
import lotto.io.PurchasePrintHandler;
import lotto.io.ResultPrintHandler;
import lotto.io.request.LottoRequest;
import lotto.io.request.NumberRequest;

public class LottoService {

    private final InputHandler inputHandler;
    private final PurchasePrintHandler purchasePrintHandler;
    private final ResultPrintHandler resultPrintHandler;

    public LottoService() {
        this.inputHandler = new InputHandler();
        this.purchasePrintHandler = new PurchasePrintHandler();
        this.resultPrintHandler = new ResultPrintHandler();
    }

    public void run() {
        Lottos lottos = getLottos();
        WinningLotto winningLotto = getWinningLotto();
        playLotto(lottos, winningLotto);
    }

    private Lottos getLottos() {
        NumberRequest request = inputHandler.getBudgets();
        return createLottos(request);
    }

    private Lottos createLottos(NumberRequest request) {
        int budgets = Integer.parseInt(request.number());
        Lottos lottos = Lottos.from(budgets);
        purchasePrintHandler.printPurchaseAmounts(lottos.getAmounts());
        purchasePrintHandler.printPurchaseResult(lottos.getPurchaseLotto());
        return lottos;
    }

    private WinningLotto getWinningLotto() {
        Lotto lotto = getWinningNumber();
        int bonusNumber = getBonusNumber();
        return createWinningLotto(lotto, bonusNumber);
    }

    private Lotto getWinningNumber() {
        LottoRequest lottoRequest = inputHandler.getWinningNumbers();
        LottoExtractor extractor = new LottoExtractor();
        List<Integer> numbers = extractor.extractLotto(lottoRequest.winningNumbers());
        return new Lotto(numbers);
    }

    private int getBonusNumber() {
        NumberRequest numberRequest = inputHandler.getBonusNumber();
        return Integer.parseInt(numberRequest.number());
    }

    private WinningLotto createWinningLotto(Lotto lotto, int bonusNumber) {
        return WinningLotto.from(lotto, bonusNumber);
    }

    private void playLotto(Lottos lottos, WinningLotto winningLotto) {
        WinningChecker winningChecker = new WinningChecker(lottos, winningLotto);
        Result results = winningChecker.checkWinning();
        printResult(results);
        int budget = lottos.getAmounts() * 1000;
        printProfitRate(results, budget);
    }

    private void printResult(Result results) {
        resultPrintHandler.printWinningStatics();
        resultPrintHandler.printFifthPrize(results.getResultCount(Ranking.FIFTH));
        resultPrintHandler.printFourthPrize(results.getResultCount(Ranking.FOURTH));
        resultPrintHandler.printThirdPrize(results.getResultCount(Ranking.THIRD));
        resultPrintHandler.printSecondPrize(results.getResultCount(Ranking.SECOND));
        resultPrintHandler.printFirstPrize(results.getResultCount(Ranking.FIRST));
    }

    private void printProfitRate(Result results, int budget) {
        Profit profit = Profit.from(results, budget);
        float profitRate = profit.calculateProfitRate();
        resultPrintHandler.printProfitRate(profitRate);
    }
}
