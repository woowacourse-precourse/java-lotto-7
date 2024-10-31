package lotto.service;

public class StatisticService {

    private final CalculateService calculateService;

    public StatisticService(final CalculateService calculateService) {
        this.calculateService = calculateService;
    }

}
