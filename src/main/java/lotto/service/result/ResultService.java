package lotto.service.result;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.utils.Parser;
import lotto.utils.ProfitCalculator;
import lotto.utils.StatisticCalculator;

public class ResultService {

    public List<String> resultProcess(User user, Lotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> result = statisticsCalculator(user, winningLotto, bonusNumber);
        double profit = profitCalculator(user, result);
        return Parser.parsingResult(result, profit);
    }

    private List<Integer> statisticsCalculator(User user, Lotto winningLotto, BonusNumber bonusNumber) {
        return StatisticCalculator.calculateStatistics(user, winningLotto, bonusNumber);
    }

    private double profitCalculator(User user, List<Integer> result) {
        return ProfitCalculator.calculateProfit(user, result);
    }
}
