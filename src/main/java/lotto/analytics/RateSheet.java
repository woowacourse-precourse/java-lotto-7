package lotto.analytics;

public record RateSheet(double growthRate) {

    public void printGrowthRate() {
        System.out.println("총 수익률은 " + growthRate + "%입니다.");
    }
}
