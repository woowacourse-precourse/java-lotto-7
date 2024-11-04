package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGenerator {

    private final LottoMachine lottoMachine = new LottoMachine();

    public void start() {
    int purchaseAmount = InputManager.readPurchaseAmount();

    int lottoCount = lottoMachine.calculateLottoCount(purchaseAmount);
    List<List<Integer>> lottoTickets = lottoMachine.generateLottoTickets(lottoCount);

    OutputManager.printLottoCount(lottoCount);
    OutputManager.printLottoTickets(lottoTickets);

    List<Integer> winningNumbers = InputManager.readWinningNumbers();
    int bonusNumber = InputManager.readBonusNumber();

    LottoResultChecker lottoResultChecker = new LottoResultChecker(winningNumbers, bonusNumber);

    List<MatchCountMessage> winningResults = new ArrayList<>();
    for (List<Integer> ticket : lottoTickets) {
        winningResults.add(lottoResultChecker.checkRanking(ticket));
    }

        Map<MatchCountMessage, Integer> winningStatistics = calculateWinningStatistics(winningResults);
        OutputManager.printWinningStatistics(winningStatistics);

        long totalProfit = ProfitCalculator.calculateTotalProfit(winningResults);
        double profitRate = ProfitCalculator.calculateProfitRate(totalProfit, purchaseAmount);
        OutputManager.printProfitRate(profitRate);
    }

    // 당첨 결과 리스트에서 등수별 개수를 세어 통계 맵을 생성
    private Map<MatchCountMessage, Integer> calculateWinningStatistics(List<MatchCountMessage> winningResults) {
        Map<MatchCountMessage, Integer> statistics = new HashMap<>();
        for (MatchCountMessage result : winningResults) {
            statistics.put(result, statistics.getOrDefault(result, 0) + 1);
        }
        return statistics;




    }
}
