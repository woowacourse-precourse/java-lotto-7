package lotto.service.result;

public class ResultService {
    private final StatisticService statisticService;
    private final ProfitService profitService;

    public ResultService(StatisticService statisticService, ProfitService profitService) {
        this.statisticService = statisticService;
        this.profitService = profitService;
    }
}
