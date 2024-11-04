package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGenerator {

    private final LottoMachine lottoMachine = new LottoMachine();

    public void start() {
        try {
            int purchaseAmount = InputManager.readPurchaseAmount();

            int lottoCount = lottoMachine.calculateLottoCount(purchaseAmount);
            List<List<Integer>> lottoTickets = generateAndPrintLottoTickets(lottoCount);

            List<Integer> winningNumbers = InputManager.readWinningNumbers();
            int bonusNumber = InputManager.readBonusNumber(winningNumbers);

            LottoResultChecker lottoResultChecker = new LottoResultChecker(winningNumbers, bonusNumber);
            List<MatchCountMessage> winningResults = getWinningResults(lottoTickets, lottoResultChecker);

            Map<MatchCountMessage, Integer> winningStatistics = calculateWinningStatistics(winningResults);
            printStatisticsAndProfit(winningStatistics, winningResults, purchaseAmount);

        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.INVALID_INPUT_FORMAT.getErrorMessage());
            start();
        }
    }

    private List<List<Integer>> generateAndPrintLottoTickets(int lottoCount) {
        List<List<Integer>> lottoTickets = lottoMachine.generateLottoTickets(lottoCount);
        OutputManager.printLottoCount(lottoCount);
        OutputManager.printLottoTickets(lottoTickets);
        return lottoTickets;
    }

    private List<MatchCountMessage> getWinningResults(List<List<Integer>> lottoTickets, LottoResultChecker lottoResultChecker) {
        List<MatchCountMessage> winningResults = new ArrayList<>();
        for (List<Integer> ticket : lottoTickets) {
            winningResults.add(lottoResultChecker.checkRanking(ticket));
        }
        return winningResults;
    }

    private void printStatisticsAndProfit(Map<MatchCountMessage, Integer> winningStatistics, List<MatchCountMessage> winningResults, int purchaseAmount) {
        OutputManager.printWinningStatistics(winningStatistics);
        long totalProfit = ProfitCalculator.calculateTotalProfit(winningResults);
        double profitRate = ProfitCalculator.calculateProfitRate(totalProfit, purchaseAmount);
        OutputManager.printProfitRate(profitRate);
    }

    private Map<MatchCountMessage, Integer> calculateWinningStatistics(List<MatchCountMessage> winningResults) {
        Map<MatchCountMessage, Integer> statistics = new HashMap<>();
        for (MatchCountMessage result : winningResults) {
            statistics.put(result, statistics.getOrDefault(result, 0) + 1);
        }
        return statistics;
    }
}
