package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    private LottoGenerator lottoGenerator;
    private LottoResult lottoResult;
    private List<Lotto> lottoTickets;
    private Lotto winningLotto;
    private int bonusNumber;
    private int budget;

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
        purchaseLottoTickets();
        setWinningInfo();
        getResults();
    }
    private void purchaseLottoTickets(){
        outputHandler.printBudgetMessage();
        budget = inputHandler.budgetInput();
        int purchasedLottoCount = budget / 1000;
        outputHandler.printPurchasedLottoCount(purchasedLottoCount);
        lottoTickets = lottoGenerator.generate(purchasedLottoCount);
        outputHandler.printLottoTickets(lottoTickets);
    }
    private void setWinningInfo(){
        outputHandler.printWinningLottoMessage();
        winningLotto = inputHandler.winningNumbersInput();
        outputHandler.printBonusNumberMessage();
        bonusNumber = inputHandler.bonusNumberInput(winningLotto.getNumbers());
    }
    private void getResults(){
        Map<Rank, Integer> result = lottoResult.getFinalResult(lottoTickets, winningLotto.getNumbers(), bonusNumber);
        outputHandler.printStatistics(result);
        float totalProfit = lottoResult.getTotalProfit(result);
        outputHandler.printRateOfReturn(totalProfit, budget);
    }

}
