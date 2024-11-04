package lotto.analytics;

public record RateSheet(double growthRate) {

    private static final String GROWTH_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printGrowthRate() {
        System.out.printf(GROWTH_RATE_MESSAGE, growthRate);
    }
}
