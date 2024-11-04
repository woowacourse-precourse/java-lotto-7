package lotto.analytics;

public class AnalyticsManager {

    private final Analyzer analyzer = new Analyzer();

    public RateSheet process(double payment, double totalPrizeAmount) {
        return new RateSheet(analyzer.calculateRate(payment, totalPrizeAmount));
    }
}
