package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    private LottoGenerator lottoGenerator;
    private List<Lotto> lottoTickets;
    private LottoResult lottoResult;

    public Application() {
        inputHandler = new InputHandler();
        outputHandler = new OutputHandler();
        lottoGenerator = new LottoGenerator();
        lottoResult = new LottoResult();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        outputHandler.printBudgetMessage();
        int budget = inputHandler.budgetInput();
        int purchasedLottoCount = budget / 1000;
        outputHandler.printPurchasedLottoCount(purchasedLottoCount);

        lottoTickets = lottoGenerator.generate(purchasedLottoCount);
        outputHandler.printLottoTickets(lottoTickets);
        outputHandler.printWinningLottoMessage();
        Lotto winningLotto = inputHandler.winningNumbersInput();
        outputHandler.printBonusNumberMessage();
        int bonusNumber = inputHandler.bonusNumberInput(winningLotto.getNumbers());

        Map<Rank, Integer> result = lottoResult.getFinalResult(lottoTickets, winningLotto.getNumbers(), bonusNumber);
        outputHandler.printStatistics(result);
        float totalProfit = lottoResult.getTotalProfit(result);
        outputHandler.printRateOfReturn(totalProfit, budget);
    }
}
