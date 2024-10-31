package lotto.service.result;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.User;

public class ResultService {
    private final StatisticService statisticService;
    private final ProfitService profitService;

    public ResultService(StatisticService statisticService, ProfitService profitService) {
        this.statisticService = statisticService;
        this.profitService = profitService;
    }

    public List<Integer> statistics(User user, Lotto winningLotto, BonusNumber bonusNumber) {
        return statisticService.statisticsCalculator(user, winningLotto, bonusNumber);
    }
}
