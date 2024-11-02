package lotto.service.result;

import java.util.List;
import lotto.domain.User;
import lotto.domain.WinningNumber;
import lotto.utils.Calculator.ProfitCalculator;
import lotto.utils.Calculator.StatisticCalculator;
import lotto.utils.parser.Parser;

public class ResultService {

    public List<String> resultProcess(User user, WinningNumber winningNumber) {
        List<Integer> result = statisticsCalculator(user, winningNumber);
        double profit = profitCalculator(user, result);
        return Parser.parsingResult(result, profit);
    }

    private List<Integer> statisticsCalculator(User user, WinningNumber winningNumber) {
        return StatisticCalculator.calculateStatistics(user, winningNumber);
    }

    private double profitCalculator(User user, List<Integer> result) {
        return ProfitCalculator.calculateProfit(user, result);
    }
}
