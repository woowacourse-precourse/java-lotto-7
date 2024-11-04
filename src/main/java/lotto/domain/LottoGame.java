package lotto.domain;

import lotto.handler.*;
import lotto.util.NumberGenerator;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoGame {

    private final OutputView outputView;
    private final InputView inputView;
    private final Parser parser;
    private final NumberGenerator numberGenerator;

    public LottoGame() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.parser = new Parser();
        this.numberGenerator = new NumberGenerator();
    }

    public void run() {
        PurchaseMoney purchaseMoney = getPurchaseMoney();

        Lottos lottos = getLottos(purchaseMoney);

        WinningNumber winningNumber = getWinningNumber();

        getBonusNumber(winningNumber);

        MatchCalculator matchCalculator = getMatchCalculator(lottos, winningNumber);

        printMatchResult(matchCalculator);

        printEarnRate(matchCalculator);
    }

    private PurchaseMoney getPurchaseMoney() {
        outputView.inputLottoMoney();
        return executeWithTryCatch(new PurchaseMoneyOperation(inputView));
    }

    private WinningNumber getWinningNumber() {
        outputView.inputWinningNumber();
        return executeWithTryCatch(new WinningNumberOperation(inputView, parser));
    }

    private void getBonusNumber(WinningNumber winningNumber) {
        outputView.inputBonusNumber();
        executeWithTryCatch(new BonusNumberOperation(inputView, winningNumber));
    }

    private Lottos getLottos(PurchaseMoney purchaseMoney) {
        outputView.purchaseLottoAmount(purchaseMoney.getMoney());
        LottoMachine lottoMachine = new LottoMachine(numberGenerator, purchaseMoney);
        Lottos lottos = lottoMachine.createLottos();
        outputView.purchaseLottoNumbers(lottos);
        return lottos;
    }

    private static MatchCalculator getMatchCalculator(Lottos lottos, WinningNumber winningNumber) {
        MatchCalculator matchCalculator = new MatchCalculator(winningNumber, lottos);
        matchCalculator.calculatePrize();
        return matchCalculator;
    }

    private void printMatchResult(MatchCalculator matchCalculator) {
        Map<Prize, Integer> prizes = matchCalculator.getPrizes();
        outputView.winningDetails(prizes);
    }

    private void printEarnRate(MatchCalculator matchCalculator) {
        double earnRate = matchCalculator.calculateEarnRate();
        outputView.earnRate(earnRate);
    }

    private <T> T executeWithTryCatch(Operation<T> operation) {
        TryCatchHandler<T> handler = new TryCatchHandler<>();
        return handler.execute(operation);
    }
}
