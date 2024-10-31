package lotto.service.result;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.utils.Parser;

public class ResultService {
    private final StatisticService statisticService;
    private final ProfitService profitService;

    public ResultService(StatisticService statisticService, ProfitService profitService) {
        this.statisticService = statisticService;
        this.profitService = profitService;
    }

    public List<String> resultProcess(User user, Lotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> result = statisticProcess(user,winningLotto,bonusNumber);
        double profit = profitProcess(user, result);
        return Parser.parsingResult(result, profit);
    }

    private List<Integer> statisticProcess(User user, Lotto winningLotto, BonusNumber bonusNumber) {
        return statisticService.statisticsCalculator(user, winningLotto, bonusNumber);
    }

    private double profitProcess(User user, List<Integer> result) {
        return profitService.profitCalculator(user, result);
    }
}
